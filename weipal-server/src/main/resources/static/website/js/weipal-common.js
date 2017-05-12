/**
 * common
 * @author shicheng
 */
var WeipalCommon = function () {

  /**
   * event element
   * @type {{}}
   */
  var eventElement = {
    codeEditor: 'edit_area',
    codeEditorMenu: '.CodeMirror',
    codeEditorExecute: '.editor-execute',
    codeEditorFormat: '.editor-format',
    codeEditorUndo: '.editor-undo',
    codeEditorRedo: '.editor-redo',
    codeEditorClear: '.editor-clear',
  }

  var showMessage = function (title, message, icon) {
    iziToast.error({
      title: title,
      message: message,
      position: 'topRight',
      transitionIn: 'fadeInDown',
      icon: icon,
      close: true,
      progressbar: true,
      /* timeout: 0 */
    });
  }

  var closeMessage = function () {
    iziToast.destroy();
  }

  return {
    eventElement: eventElement,
    showMessage: showMessage,
    closeMessage: closeMessage
  }
}()