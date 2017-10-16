$(document).ready(function() {

	$.ajax({
		url : "list?token=1",
		success : function(result) {
			$("#list").html(result);
		}
	});

});