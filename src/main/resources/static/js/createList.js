var userId = 1;

function createList(e) {
	
	e.preventDefault();
	
	var listName = $("#name").val();
	
	$.ajax({
		url : "list/"+listName+"?id="+userId,
		method : "POST",
		success : redirectToIndex()
	});
	
}

function redirectToIndex() {
	document.location.href="/";
}