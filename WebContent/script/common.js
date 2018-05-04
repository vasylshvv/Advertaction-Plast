$(document).ready(function() {
  $("#menu").css({ 'visibility': 'visible', 'height': 'auto' });
  $("#menu").mmenu({
    navbar: { title: 'Меню'}
  }, {
    offCanvas: {
      pageSelector: "#wrapper"
    }
  });
  var $icon = $("#menu-icon");
  var API = $("#menu").data( "mmenu" );

  $("#hamburger").click(function() {
    API.open();
  });

  API.bind( "open:finish", function() {
    setTimeout(function() {
      $icon.addClass( "is-active" );
    }, 100);
  });
  API.bind( "close:finish", function() {
    setTimeout(function() {
      $icon.removeClass( "is-active" );
    }, 100);
  });
});