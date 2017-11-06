$(document).ready(function() {
	var userId = readCookie("userId");
	if(userId){
		createCookie("userId",Math.trunc(Math.random()*100000)+1,60000); // 60 sec
	}
	
	$.ajax({
		url : "list?token="+userId,
		success : loadLists
	});

});

function loadLists(data) {
	
	$("#lists").empty();
	
	if(data.length == 0) {
		//On affiche la table vide
		displayEmptyTable();
	} else {
		displayTable(data);
	}
	
}

function displayTable(data) {
	
	var list;
	var tr, th_name, th_edit, th_delete;
	var td_name, td_edit, td_delete;
	var icon_edit, icon_delete;
	var tbody = $("<tbody>");
	
	//En-tête
	tr = $("<tr>");
	th_name = $("<th>").text("Nom de la liste");
	th_edit= $("<th>").text("Modifier").addClass("col-md-1");
	th_delete= $("<th>").text("Supprimer").addClass("col-md-1");
	tr.append(th_name);
	tr.append(th_edit);
	tr.append(th_delete);
	tbody.append(tr);

	//Contenu
	for(var i in data) {
		list = data[i];
		tr = $("<tr>").addClass("table-row");
		td_name = $("<td>").text(list.name);
		td_edit = $("<td>");
		td_delete = $("<td>");
		icon_edit = $("<img>").addClass("icon").attr("src", "icons/edit.png");
		icon_edit.click(function(){
			document.location.href="/detailList?nameList="+list.name;
		});
		icon_delete = $("<img>").addClass("icon").attr("src", "icons/delete.png");
		icon_delete.click(function(){
			$.ajax({
					url : "list?nameList="+list.name+"&token="+userId,
    				type: 'DELETE',
					success : loadLists
				});
		});
		td_edit.append(icon_edit);
		td_delete.append(icon_delete);
		tr.append(td_name);
		tr.append(td_edit);
		tr.append(td_delete);
		tbody.append(tr);
	}
	
	$("#lists").append(tbody);
}

function displayEmptyTable() {
	var tr = $("<tr>").addClass("table-row");
	var td = $("<td>").text("Vous n'avez aucune liste");
	tr.append(td);
	$("#lists").append(tr);
}
