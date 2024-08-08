function moveTabs(evt, name) {
  $(".tabcontent").hide();
  $(".tablinks").removeClass("active");
  $(".tablinks").removeClass("bg-dark");
  $("#" + name).show();
  $(evt.currentTarget).addClass("active");
  $(evt.currentTarget).addClass("bg-dark");
}