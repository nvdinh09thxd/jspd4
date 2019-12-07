<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link href="<%=request.getContextPath()%>/baitap/BT1/css/reset.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/baitap/BT1/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="wrapper">
			<h2>Login</h2>
			<form action="<%=request.getContextPath()%>/xu-ly-login" method="post">
				<label>Tên đăng nhập:</label> 
				<input type="text" name="username" /><br /><br /> 
				<label>Mật khẩu:</label> 
				<input type="password" name="password" /><br /><br />
				<input type="submit" value="Đăng nhập" />
			</form>
			<%
				String err = request.getParameter("err");
				if("0".equals(err)) out.print("<p style='color: red'>Vui long nhap day du thong tin vao</p>");
			%>
		</div>
	</body>
</html>