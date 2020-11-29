<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- PAGE OF INSTRUCTORS -->
<html>
<head>
<title>Instructor Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>To do list</h2>
	</div>
</div>

<form action="AddToDoServlet" method="get">
<input type="submit" value="Add Todo" />
</form>
<td>Welcome</td>
<%
	String welcome = (String) request.getAttribute("username");
%>
<%=welcome%>
<div id="container">
	<div id="content">
	<table>			
		<tr>
			<th>To Do</th>

			<th>Actions</th>
			<th></th>
		</tr>
		<c:forEach var="tempTodo" items="${TODO_LIST}">
			<c:url var="EditLink" value="EditToDoServlet">
				<c:param name="todoId" value="${tempTodo.id}" />
				</c:url>
				<c:url var="DelLink" value="DeleteToDoServlet">
					<c:param name="todoId" value="${tempTodo.id}" />
				</c:url>
			<tr>
				<td>${tempTodo.descrip}</td>
				<td><a href="${EditLink}"> Edit</a></td>
				<td><a href="${DelLink}"> Delete</a></td>
			</tr>
		</c:forEach>	
	</table>
	</div>
</div>

<form action="WebToDoListControllerServlet" method="get">
<input type="submit" value="Back to login" />
</form>

</body>
</html>
