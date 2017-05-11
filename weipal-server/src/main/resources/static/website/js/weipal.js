'use strict';
$(document).ready(function () {
  $('.time-since').each(function () {
    $(this).addClass('poping up').attr('data-content', $(this).attr('title')).attr('data-variation', 'inverted tiny').attr('title', '');
  });
  $('.ui.dropdown').dropdown({
    forceSelection: false
  });
  $('.jump.dropdown').dropdown({
    action: 'select',
    onShow: function () {
      $('.poping.up').popup('hide');
    }
  });
  $('.slide.up.dropdown').dropdown({
    transition: 'slide up'
  });
  $('.upward.dropdown').dropdown({
    direction: 'upward'
  });
  $('.ui.accordion').accordion();
  $('.ui.checkbox').checkbox();
  $('.ui.progress').progress({
    showActivity: false
  });
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
  $('.toggle.button').click(function () {
    $($(this).data('target')).slideToggle(100);
  });

  WeipalCodeEditor.initCodeEditor('edit_area', null);


  $(function () {
    $('.CodeMirror').contextPopup({
      title: 'Editor Quick Link',
      items: [
        {
          label: 'Execute', icon: 'octicon octicon-rocket', action: function () {
        }
        },
        {
          label: 'Format', icon: 'octicon octicon-file-code', action: function () {
        }
        },
        {
          label: 'Undo', icon: 'octicon octicon-cloud-upload', action: function () {
        }
        },,
        {
          label: 'Redo', icon: 'octicon octicon-cloud-download', action: function () {
        }
        },
        null,
        {
          label: 'Clear', icon: 'octicon octicon-trashcan', action: function () {
        }
        }
      ]
    });
  });

});