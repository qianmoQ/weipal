/**
 * code editor
 * @author shicheng
 */
var WeipalCodeEditorMenu = function () {

  /**
   * init menu
   * @param codeMirrorId editor id
   * @param options config
   */
  var initMenu = function (menuElement) {
    $(menuElement).contextPopup({
      title: 'Editor Quick Link',
      items: [
        {
          label: 'Execute',
          icon: 'octicon octicon-rocket',
          action: function () {
            if (WeipalCodeEditor.getValue() == '') {
              WeipalCommon.showMessage(WeipalCode.warning, WeipalCode.sql_not_null, 'octicon octicon-alert');
              return;
            }
          }
        },
        {
          label: 'Format',
          icon: 'octicon octicon-file-code',
          action: function () {
            if (WeipalCodeEditor.getValue() == '') {
              WeipalCommon.showMessage(WeipalCode.warning, WeipalCode.sql_not_null, 'octicon octicon-alert');
              return;
            }
          }
        },
        {
          label: 'Undo',
          icon: 'octicon octicon-cloud-upload',
          action: function () {
            WeipalCodeEditor.undoValue();
          }
        }, ,
        {
          label: 'Redo',
          icon: 'octicon octicon-cloud-download',
          action: function () {
            WeipalCodeEditor.redoValue();
          }
        },
        null,
        {
          label: 'Clear',
          icon: 'octicon octicon-trashcan',
          action: function () {
            WeipalCodeEditor.clearValue();
          }
        }
      ]
    });
  }

  return {
    initCodeEditorMenu: initMenu
  }

}()