'use strict';
$(document).ready(function () {
    // $('.time-since').each(function () {
    //   $(this).addClass('poping up').attr('data-content', $(this).attr('title')).attr('data-variation', 'inverted tiny').attr('title', '');
    // });
    $('.ui.dropdown').dropdown({
        forceSelection: false
    });
    // $('.jump.dropdown').dropdown({
    //   action: 'select',
    //   onShow: function () {
    //     $('.poping.up').popup('hide');
    //   }
    // });
    // $('.slide.up.dropdown').dropdown({
    //   transition: 'slide up'
    // });
    // $('.upward.dropdown').dropdown({
    //   direction: 'upward'
    // });
    $('.ui.accordion').accordion();
    $('.ui.checkbox').checkbox();
    $('.poping.up').popup();
    $('.top.menu .poping.up').popup({
        onShow: function () {
            if ($('.top.menu .menu.transition').hasClass('visible')) {
                return false;
            }
        }
    });
    $('.tabular.menu .item').tab();
    $('.tabable.menu .item').tab();

    WeipalCodeEditor.initCodeEditor(WeipalCommon.eventElement.codeEditor, null);
    WeipalEvent.initEvent();
    WeipalCodeEditorMenu.initCodeEditorMenu(WeipalCommon.eventElement.codeEditorMenu);

});