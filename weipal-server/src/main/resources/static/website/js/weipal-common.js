/**
 * common
 * @author shicheng
 */
var WeipalCommon = function () {

  var getApi = function () {
    return 'http://172.16.39.133:8080';
  }

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
    getApi: getApi,
    eventElement: eventElement,
    showMessage: showMessage,
    closeMessage: closeMessage
  }
}()