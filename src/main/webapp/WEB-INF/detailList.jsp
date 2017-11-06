<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Création de liste</title>
	 <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/list.css">
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>	
	<script type="text/javascript" src="js/cookie.js"></script>

	<script type="text/javascript" src="js/viewList.js"></script>
</head>
<body>

	<h3>Création de liste</h3>
	
	<ul id="elementslists">

	</ul>


	<form class="form-horizontal" onsubmit="addElementAtList(event);">
		<div class="form-group">
			<div class="col-sm-6">
				<input type="text" name="name" id="name" class="form-control" />
			</div>
			<button type="submit" class="col-sm-2 btn btn-default">Ajouter</button>
		</div>
	</form>

</body>
</html>