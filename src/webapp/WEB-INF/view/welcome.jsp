<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- id:<input type="text" name="id"/><br>
		password:<input type="password" name="psd"/>
			age:<input type="text" name="age"/><br>
		<br>
		<input type="submit" name="login" value="login"/> -->
			<h1>for store persion:</h1><br>
		<form action="${pageContext.servletContext.contextPath}/add-persion">
			name:<input type="text" name="name"/><br>
			age:<input type="text" name="name"/><br>
			<button type="submit">save</button>>		
		<form>
	</body>
</html>