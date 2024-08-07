function openCity(evt, name) {
  $(".tabcontent").hide();
  $(".tablinks").removeClass("active");
  $("#" + name).show();
  $(evt.currentTarget).addClass("active");
}
