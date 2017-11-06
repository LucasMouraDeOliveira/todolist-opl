
$(document).ready(function() {
	
	var userId = readCookie("userId");
	var listName = urlParam('nameList');
	if(!userId || !listName){
		document.location.href="/";
	}
	$.ajax({
		url : "list?listName="+listName+"&token="+userId,
		success : loadElementsLists
	});

});


function loadElementsLists(data) {
	
	$("#elementslists").empty();
	
	if(data.length == 0) {
		//On affiche la table vide
		displayEmptyTable();
	} else {
		displayTable(data);
	}
	
}

function displayTable(data) {
	
	var li,element,icon_delete;
	
	//Contenu
	for(var i in data) {
		element = data[i];
		li = $("<li>").text(element.name);
		icon_delete = $("<img>").addClass("icon").attr("src", "icons/delete.png");
		li.append(icon_delete);
		$("#elementslists").append(li);
	}
}

function displayEmptyTable() {
	var h3 = $("<h3>").text("Vous n'avez rien à faire.");
	$("#elementslists").append(h3);
}

function addElementAtList(e) {
	
	e.preventDefault();
	var element = $("#name").val();
	
	$.ajax({
		url : "list/"+listName+"/"+element+"?token="+userId,
		method : "PUT",
		success : redirectToIndex()
	});
	
}

function removeElementAtList(e) {
	
	e.preventDefault();
	var element = $("#name").val();
	
	$.ajax({
		url : "list/"+listName+"/"+element+"?token="+userId,
		method : "DELETE",
		success : redirectToIndex()
	});
	
}