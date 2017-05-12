/**
 * code event
 * @author shicheng
 */
var WeipalEvent = function () {

  var editorRun = function () {
    $(WeipalCommon.eventElement.codeEditorExecute).click(function () {
      if (WeipalCodeEditor.getValue() == '') {
        WeipalCommon.showMessage(WeipalCode.warning, WeipalCode.sql_not_null, 'octicon octicon-alert');
        return;
      }
    });
  }

  var editorFormat = function () {
    $(WeipalCommon.eventElement.codeEditorFormat).click(function () {
      if (WeipalCodeEditor.getValue() == '') {
        WeipalCommon.showMessage(WeipalCode.warning, WeipalCode.sql_not_null, 'octicon octicon-alert');
        return;
      }

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

  return {
    initEvent: initEvent
  }

}()