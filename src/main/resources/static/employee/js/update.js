$(function () {
  if (window.location.pathname === "/employee/add") {
    $("#title-Text").text("Add New Employee");

    $("#form-data").attr("action", "save");

    $("#update").hide();
    $("#create").show();
  } else {
    $("#title-Text").text("Update Employee");

    $("#form-data").attr("action", "update");
    $("#id-employee").attr("readonly", "readonly");

    $("#create").hide();
    $("#update").show();
    $("#cancel").hide();
  }

  $("#back-list").click(function () {
    window.location.href = "list";
  });

  $("#Office").change(function () {
    if ($(this).val() == "Services" && $(".mService").length == 0) {
      changeValueDuty();
    } else if ($(this).val() == "Engineering" && $(".mEngin").length == 0) {
      changeValueDuty();
    } else if ($(this).val() == "Environment" && $(".mEnviront").length == 0) {
      changeValueDuty();
    } else {
      $("#dutyMana").show();
      $("#dutyEmp").show();
    }
  });

  function changeValueDuty() {
    $("#dutyMana").prop("selected", true);
    $("#dutyMana").show();
    $("#dutyEmp").hide();
  }
});
