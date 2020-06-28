<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
<link href="<%=request.getContextPath() %>/demo/css/reset.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/demo/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="wrapper">
	<h2>Login</h2>
		<form action="<%=request.getContextPath() %>/xu-ly-login" method="post">
			<label>Username:</label> <input type="text" name="username" /><br />
			<br /> <label>Password:</label> <input type="password"
				name="password" /><br />
			<br /> <input type="submit" value="Login" />
		</form>
	</div>
</body>
</html>