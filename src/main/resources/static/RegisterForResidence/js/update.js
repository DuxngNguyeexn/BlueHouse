$(function() {
	if (window.location.pathname === '/registerForResidence/add') {
		
		$('#title-Text').text('Add New RegiForResi');

		$('#form-data').attr('action', 'save');

		$('#update').hide();
		$('#create').show();

	} else {
		
		$('#title-Text').text('Update RegiForResi');

		$('#form-data').attr('action', 'update');
		$('#id-residence').attr('readonly', 'readonly');

		$('#create').hide();
		$('#update').show();
		$('#cancel').hide();
	}

	$('#back-list').click(function() {
		window.location.href = 'list';
	});
});

const REGEX_ID = /^RFS\d{3}$/;
const REGEX_NAME = /^[a-zA-Z\s]{5,50}$/;
const REGEX_CCCD = /^\d{12}$/;
const REGEX_TYPE = /^(Luu Tru Ngan Han|Luu Tru Dai Han)$/;
const REGEX_PHONE = /^09\d{8,9}$/;

function validate(event) {
	event.preventDefault();
	let check = true;

	let idresi = $("#id-residence").val();
	let rela = $("#relationshipWithHomeowner").val();
	let idNati = $("#idNational").val();
	let type = $("#type").val();
	let Phone = $("#phone").val();
	let birthofdate = $("#dateOfBirth").val();
	let moveindate = $("#moveInDate").val();
	let moveoutdate = $("#moveOutDate").val();

	if (!REGEX_ID.test(idresi)) {
		$("#idResi-error").text("wrong format RFSxxx");
		check = false;
	} else {
		$("#idResi-error").text("");
	}

	if (!REGEX_NAME.test(rela)) {
		$("#rela-error").text("wrong format only text");
		check = false;
	} else {
		$("#rela-error").text("");
	}

	if (!REGEX_CCCD.test(idNati)) {
		$("#idNati-error").text("wrong format 12 number");
		check = false;
	} else {
		$("#idNati-error").text("");
	}

	if (!REGEX_TYPE.test(type)) {
		$("#type-error").text("wrong format");
		check = false;
	} else {
		$("#type-error").text("");
	}

	if (!REGEX_PHONE.test(Phone)) {
		$("#phone-error").text("wrong format 09 and 10 or 11 number");
		check = false;
	} else {
		$("#phone-error").text("");
	}

	/*if (!REGEX_DAYOFBIRTH.test(moveoutdate)) {
		$("#moveOutDate-error").text("please choose date < 2006");
		check = false;
	} else {
		$("#moveOutDate-error").text("");
	}
	
	if (!REGEX_DAYOFBIRTH.test(moveindate)) {
		$("#moveInDate-error").text("please choose date < 2006");
		check = false;
	} else {
		$("#moveInDate-error").text("");
	}
	
	if (!REGEX_DAYOFBIRTH.test(birthofdate)) {
		$("#dateBirth-error").text("please choose date < 2006");
		check = false;
	} else {
		$("#dateBirth-error").text("");
	}
*/
	if (check) {
		document.getElementById("create").dispatchEvent(new MouseEvent("click"));
	}
}
