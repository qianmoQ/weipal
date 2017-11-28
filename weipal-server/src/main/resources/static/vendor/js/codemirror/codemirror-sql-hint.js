(function (mod) {
    if (typeof exports == "object" && typeof module == "object") // CommonJS
        mod(require("../../lib/codemirror"), require("../../mode/sql/sql"));
    else if (typeof define == "function" && define.amd) // AMD
        define(["../../lib/codemirror", "../../mode/sql/sql"], mod);
    else // Plain browser env
        mod(CodeMirror);
})(function (CodeMirror) {
    "use strict";
    var Pos = CodeMirror.Pos;

    /**
     * get keyword array by sql.js
     * @param {Object} editor
     */
    function getKeywords(editor) {
        var mode = editor.doc.modeOption;
        if (mode === "sql") mode = "text/x-sql";
        return CodeMirror.resolveMode(mode).keywords;
    };

    /**
     * item existe array
     * @param {Object} arr
     * @param {Object} item
     */
    function arrayContains(arr, item) { // item existe array
        if (!Array.prototype.indexOf) {
            var i = arr.length;
            while (i--) {
                if (arr[i] === item) {
                    return true;
                }
            }
            return false;
        }
        return arr.indexOf(item) != -1;
    };

    function hintSql(editor, keywords, tableKeywords, getToken, options) {
        // Find the token at the cursor，
        var cur = editor.getCursor(),
            token = getToken(editor, cur),
            tprop = token;
        return {
            list: getCompletions(token, keywords, tableKeywords, options),
            // string split init position
            from: Pos(cur.line, fetchStartPoint(token)),
            to: Pos(cur.line, token.end)
        };
    };

    /**
     * string join position
     * @param {Object} token
     */
    function fetchStartPoint(token) {
        var index = token.string.lastIndexOf("\.");
        if (index < 0) {
            return token.start;
        } else {
            return token.start + index + 1;
        }
        //      return token.start;
    };

    function sqlHint(editor, options) {
        var keywords = wordToString(getKeywords(editor)) + CodeMirror.keywords;
        return hintSql(editor, keywords, CodeMirror.tableKeywords, function (e, cur) {
            return e.getTokenAt(cur);
        }, options);
    };
    CodeMirror.registerHelper("hint", "sql", sqlHint);

    /**
     * get high array
     * @param {Object} token
     * @param {Object} keywords
     * @param {Object} tableKeywords
     * @param {Object} options
     */
    function getCompletions(token, keywords, tableKeywords, options) {
        var found = [],
            start, pointCount, content = getWord(token.string, token.end); // found array
        if (content && content.length) {
            start = token.string.charAt(0); // string index
            content = content.trim().substring(0, content.lenght); // string length - 1
            pointCount = (start == '\.') ? true : false; //string last string is ..
        }
        var result = null;
        if (start && start.trim() != '') { // allow $，not analysis ${}
            if (start === '*') {
                return
            } // igion *
            var regexp = new RegExp("\\b" + content + "\\w+\\.?\\b", "gi");
            if (pointCount && tableKeywords) {
                result = tableKeywords.match(regexp);
            } else {
                result = keywords.match(regexp);
            }
            console.log('result = ' + result);
        }
        if (result && result.length) {
            for (var i = 0; i < result.length; i++) {
                if (!arrayContains(found, result[i]) && content.length <= result[i].length && pointCount) {
                    if (result[i].charAt(result[i].length - 1) == '.') { // last index is '.'
                        found.push(result[i].substring(content.lastIndexOf("\.") + 1, result[i].length - 1));
                    } else {
                        found.push(result[i].substring(content.lastIndexOf("\.") + 1, result[i].length));
                    }
                } else {
                    found.push(result[i]);
                }
            }
        }
        return found;
    };

    /**
     * get current string
     * @param {Object} str current string
     * @param {Object} end stop position
     */
    function getWord(str, end) {
        return str.substring(str.lastIndexOf(' '), end);
    };

    /**
     * wordlist join string
     * @param {Object} wordlist
     */
    function wordToString(wordlist) {
        var str = '';
        for (var word in wordlist) {
            str += word + ' ';
        }
        return str;
    };
    CodeMirror.registerHelper('lint', 'sql', function (text) {
        var found = [];
        if (!window.SQLL) return found;
        var results = CSSLint.verify(text), messages = results.messages, message = null;
        for (var i = 0; i < messages.length; i++) {
            message = messages[i];
            var startLine = message.line - 1, endLine = message.line - 1, startCol = message.col - 1,
                endCol = message.col;
            found.push({
                from: CodeMirror.Pos(startLine, startCol),
                to: CodeMirror.Pos(endLine, endCol),
                message: message.message,
                severity: message.type
            });
        }
        return found;
    })
});