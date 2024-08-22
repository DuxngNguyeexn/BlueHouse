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

const REGEX_ID = /^E\d{3}$/;
const REGEX_NAME = /^[a-zA-Z\s]{5,50}$/;
const REGEX_CCCD = /^\d{12}$/;
const REGEX_DUTY = /^(Manager|Employee)$/;
const REGEX_OFFICE = /^(Services|Engineering|Environment)$/;
const REGEX_PHONE = /^09\d{8,9}$/;
const REGEX_DAYOFBIRTH = /^(19[0-9][0-9]|200[0-6])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
const REGEX_PLACE = /^[\w\s]{5,100}$/;

function validate(event) {
  event.preventDefault();
  let check = true;

  let idEmp = $("#id-employee").val();
  let nameEmp = $("#name-emp").val();
  let CCCD = $("#CCCD").val();
  let duty = $("#duty").val();
  let Office = $("#Office").val();
  let Phone = $("#phone").val();
  let dateOfBirth = $("#dateOfBirth").val();
  let place = $("#place").val();

  if (!REGEX_ID.test(idEmp)) {
    $("#idEmp-error").text("wrong format Exxx");
    check = false;
  } else {
    $("#idEmp-error").text("");
  }

  if (!REGEX_NAME.test(nameEmp)) {
    $("#name-error").text("wrong format only text");
    check = false;
  } else {
    $("#name-error").text("");
  }

  if (!REGEX_CCCD.test(CCCD)) {
    $("#cccd-error").text("wrong format 12 number");
    check = false;
  } else {
    $("#cccd-error").text("");
  }

  if (!REGEX_DUTY.test(duty)) {
    $("#duty-error").text("wrong format");
    check = false;
  } else {
    $("#duty-error").text("");
  }

  if (!REGEX_OFFICE.test(Office)) {
    $("#office-error").text("wrong format");
    check = false;
  } else {
    $("#office-error").text("");
  }

  if (!REGEX_PHONE.test(Phone)) {
    $("#phone-error").text("wrong format 09 and 10 or 11 number");
    check = false;
  } else {
    $("#phone-error").text("");
  }

  if (!REGEX_DAYOFBIRTH.test(dateOfBirth)) {
    $("#dateOfBirth-error").text("please choose date < 2006");
    check = false;
  } else {
    $("#dateOfBirth-error").text("");
  }

  if (!REGEX_PLACE.test(place)) {
    $("#place-error").text("wrong format min 5 and max 50 character");
    check = false;
  } else {
    $("#place-error").text("");
  }

  if ($("#genderMale").is(":checked") || $("#genderFemale").is(":checked")) {
    $("#gender-error").text("");
  } else {
    $("#gender-error").text("please choose");
    check = false;
  }

  if (check) {
    document.getElementById("create").dispatchEvent(new MouseEvent("click"));
  }
}
