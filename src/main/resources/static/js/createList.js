function createList(e) {
	
	e.preventDefault();
	var userId = readCookie("userId");
	if(userId){
		return redirectToIndex();
	}
	var listName = $("#name").val();
	
	$.ajax({
		url : "list/"+listName+"?token="+userId,
		method : "POST",
		success : redirectToIndex()
	});
	
}

function redirectToIndex() {
	document.location.href="/";
}