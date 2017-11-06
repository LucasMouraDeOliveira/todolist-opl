<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TODO LIST</title>
	
	 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/list.css">
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>	
	<script type="text/javascript" src="js/cookie.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</head>
<body>

	<div class="container-fluid">
  		<div class="content-container col-lg-6 col-md-6 col-xs-6">
 	
			<h3>Vos listes : </h3>
			
 			<!-- lists container -->
			<table id="lists" class='table table-bordered table-condensed table-striped table-hover'>
			
			</table>
			
			<form action="/createList" method="get">
				<div class="form-group"> 
					<div class="col-sm-6">
						<button type="submit" class="btn btn-default">Nouvelle liste</button>
					</div>
				</div>
			</form>
 	
    	</div>   
  	</div>

</body>
</html>