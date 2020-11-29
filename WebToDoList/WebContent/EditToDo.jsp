<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Edit To Do Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Edit a ToDo</h2>
		</div>
	</div>

	<div class="container">
		<form class="form-login" action="EditToDoServlet" method="post"
			id="formWrapper">


			<div class="col-xs-6" id="descripupdate">
				<input id="descip" name="descripupdate" type="text"
					class="input-block-level" placeholder="id_ToDo"
					value="${Todo.descrip}" >
			</div>
			<div class="row-fluid">
				<input type="submit" value="Save" id="btn_next"
					class="btn btn-primary pull-right span6" />
			</div>

		</form>
		
<form action="WebToDoListControllerServlet" method="get">
<input type="submit" value="Back to login" />
</form>

	</div>
</body>
</html>