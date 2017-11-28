/**
 * code editor
 * @author shicheng
 */
var WeipalCodeEditor = function () {

    var CODE_EDITOR;

    /**
     * init editor
     * @param codeMirrorId editor id
     * @param options config
     */
    var initCodeEditor = function (codeMirrorId, options) {
        if (options === 'undefiend' || options === '' || options === null) {
            options = initOptions();
        }
        var codeMirror = document.getElementById(codeMirrorId);
        // CodeMirror.tableKeywords = "hive.aaaa";
        if (codeMirror != null) {
            var codeEditor = CodeMirror.fromTextArea(codeMirror, options);
            codeEditor.setSize('auto', '200px');
            /* auto show */
            codeEditor.on('change', function () {
                codeEditor.showHint();
            });
            CODE_EDITOR = codeEditor;
            return codeEditor;
        }
    }

    /**
     * init properties
     * @returns {{}}
     */
    var initOptions = function () {
        var options = {};
        options.lineNumbers = true;
        options.lineWrapping = true;
        options.styleActiveLine = true;
        options.auto = 'auto';
        options.mode = {name: "text/x-mysql"};
        options.theme = "eclipse";
        options.tabSize = 4;
        options.indentUnit = 4;
        options.indentWithTabs = true;
        return options;
    }

    /**
     * set value
     * @param value
     */
    var setValue = function (value) {
        CODE_EDITOR.setValue(value);
    }

    /**
     * get value
     * @returns {*}
     */
    var getValue = function () {
        var value = CODE_EDITOR.getValue().trim();
        return value;
    }

    var clearValue = function () {
        CODE_EDITOR.setValue('');
    }

    var undoValue = function () {
        CODE_EDITOR.undo();
    }

    var redoValue = function () {
        CODE_EDITOR.redo();
    }


    var highlightSearch = function (keyword) {

    }

    /**
     * highlight line
     * @param line
     */
    var highlightLine = function (line) {
        CODE_EDITOR.addLineClass(line, 'background', 'CodeMirror-error-line-background');
    }

    var getCodeEditor = function () {
        return CODE_EDITOR;
    }

    return {
        initCodeEditor: initCodeEditor,
        initOptions: initOptions,
        setValue: setValue,
        getValue: getValue,
        clearValue: clearValue,
        undoValue: undoValue,
        redoValue: redoValue,
        highlightSearch: highlightSearch,
        highlightLine: highlightLine,
        getCodeEditor: getCodeEditor
    }

}()