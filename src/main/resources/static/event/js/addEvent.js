let choose = "All";
let encodedArray;
function toggleSelectSend(display) {
	document.getElementById("select-send").style.display = display;
	document.getElementById("Choose").value = choose;
}
toggleSelectSend("none");
document.getElementById("All").addEventListener("click", function() {
	choose = "All";
	toggleSelectSend("none");
});
document.getElementById("Emp").addEventListener("click", function() {
	choose = "AllEmployee";
	toggleSelectSend("none");
});
document.getElementById("Resi").addEventListener("click", function() {
	choose = "AllResident";
	toggleSelectSend("none");
});
document.getElementById("pick").addEventListener("click", function() {
	choose = "Choosen";
	toggleSelectSend("flex");
});


document.addEventListener("DOMContentLoaded", function() {
	var selectElement = document.getElementById("ID-chosenValue");

	selectElement.addEventListener("change", function() {
		const selectElement = document.querySelector(".chosen-select")
			.selectedOptions;
		const selectedValues = [];
		for (let i = 0; i < selectElement.length; i++) {
			selectedValues.push(selectElement[i].value);
		}

		if (choose != "Choosen") {
			encodedArray = "null";
		} else {
			encodedArray = selectedValues.map(encodeURIComponent).join(",");
		}

		document.getElementById("valueSend").value = encodedArray;
	});
});
