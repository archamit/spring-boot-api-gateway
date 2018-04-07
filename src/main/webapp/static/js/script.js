$( document ).ready(function() {
  $('.tabsSection nav-tabs li a').click(function (e) {
    $(this).unbind('click');
  })
});
