/**
 * common
 * @author shicheng
 */
var WeipalCommon = function () {

  var getApi = function () {
    return 'http://192.168.99.215:8080';
  }

  var getUid = function () {
    return $('#userId').val();
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

    dataSource: '#datasource'
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
    getUid: getUid,
    eventElement: eventElement,
    showMessage: showMessage,
    closeMessage: closeMessage
  }
}()