/**
 * code event
 * @author shicheng
 */
var WeipalEvent = function () {

    var editorRun = function () {
        $(WeipalCommon.eventElement.codeEditorExecute).click(function () {
            if (WeipalCodeEditor.getValue() == '') {
                WeipalCommon.showMessage(WeipalCode.warning, WeipalCode.sqlNotNull, 'octicon octicon-alert');
                return;
            }
        });
    }

    var editorFormat = function () {
        $(WeipalCommon.eventElement.codeEditorFormat).click(function () {
            if (WeipalCodeEditor.getValue() == '') {
                WeipalCommon.showMessage(WeipalCode.warning, WeipalCode.sqlNotNull, 'octicon octicon-alert');
                return;
            }
            $.post(WeipalApi.formatSQL, {sql: WeipalCodeEditor.getValue()}, function (result) {
                if (result.code === WeipalCode.success) {
                    WeipalCodeEditor.setValue(result.data);
                    WeipalCommon.closeMessage();
                } else {
                    WeipalCommon.showMessage(WeipalCode.warning, result.data, 'octicon octicon-alert');
                }
            });
        });
    }

    var editorUndo = function () {
        $(WeipalCommon.eventElement.codeEditorUndo).click(function () {
            WeipalCodeEditor.undoValue();
        })
    }

    var editorRedo = function () {
        $(WeipalCommon.eventElement.codeEditorRedo).click(function () {
            WeipalCodeEditor.redoValue();
        })
    }

    var editorClear = function () {
        $(WeipalCommon.eventElement.codeEditorClear).click(function () {
            WeipalCodeEditor.clearValue();
        })
    }

    var initEvent = function () {
        editorRun();
        editorFormat();
        editorUndo();
        editorRedo();
        editorClear();
    }

    var initDataSource = function (id) {
        $.get(WeipalApi.getSourceById + '?uid=' + WeipalCommon.getUid(), function (result) {
            if (result.code === WeipalCode.success) {
                $(result.data).each(function (i, val) {
                    var option = '<option value="' + val.id + '">' + val.sourceName + '</option>';
                    $(WeipalCommon.eventElement.dataSource).append(option);
                });
            } else {
                WeipalCommon.showMessage(WeipalCode.warning, result.data, 'octicon octicon-alert');
            }
        });
    }

    return {
        initEvent: initEvent,
        initDataSource: initDataSource
    }

}()