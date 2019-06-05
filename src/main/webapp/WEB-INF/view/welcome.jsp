<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript" src="/jquery-3.3.1.min.js">
			$('#btn').click(url, data,function(data, status){
				$('#row').val(data.stringify());
			});
		</script>
	</head>
	<body>
		<!-- id:<input type="text" name="id"/><br>
		password:<input type="password" name="psd"/>
			age:<input type="text" name="age"/><br>
		<br>
		<input type="submit" name="login" value="login"/> -->
			<h1>For Store Persion:</h1><br>
			<b>Product Id:</b><input type="text" name="productId" id="p-id"/><br><br>
			<b>Product Name:</b><input type="text" name="productName" id="p-name"/><br><br>
			<button id="btn" type="submit">save</button>
			<div id="row"><div>		
	</body>
</html>