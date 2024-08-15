let userName;

function deleteAcc(param) {
	userName = param;
}

$('#confirmDel').click(function() {
	window.location.href = 'delete?userName='+ userName;
});
