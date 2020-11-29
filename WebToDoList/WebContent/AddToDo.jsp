<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Add To Do Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>To Do List</h2>
	</div>
</div>

	<div class="container">
		<form class="form-login" action="AddToDoServlet" method="post"
			id="formWrapper">

			<div class="col-xs-6" id="description">
				<input id="descrip" name="descrip" type="text"
					class="input-block-level" placeholder="ToDo">
			</div>

			<div class="row-fluid">
				<input type="submit" value="Add To Do" id="btn_next"
					class="btn btn-primary pull-right span6" />
			</div>
		</form>
<form action="WebToDoListControllerServlet" method="get">
<input type="submit" value="Back to login" />
</form>

</body>
</html>
