<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- PAGE OF INSTRUCTORS -->
<html>
<head>
<title>Login Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<form class="form-login" action="WebToDoListControllerServlet"
			method="post" id="formWrapper">


<div id="wrapper">
	<div id="header">
		<h2>Login Page</h2>
	</div>
</div>

			<br>
			<div class="col-xs-6" id="identifiant">
				<input id="login" name="username" type="text"
					class="input-block-level" placeholder="ID" >
			</div>
			<div class="col-xs-6" id="password">
				<input id="pass" name="password" type="password"
					class="input-block-level" placeholder="Password">
			</div>
			<br>
			<div class="row-fluid">
				<input type="submit" value="Login" id="btn_next"
					class="btn btn-primary pull-right span6" />
			</div>
		</form>

	</div>
</body>
</html>
