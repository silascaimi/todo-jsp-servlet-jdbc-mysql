<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: DodgerBlue">
			<div>
				<a href="" class="navbar-brand">ToDo App</a>
			</div>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/login" class="nav-link">Login</a></li>
				<li><a href="<%=request.getContextPath()%>/register" class="nav-link">Singup</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>