<%@page import="model.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<%
		Account account = (Account) session.getAttribute("account");
		if (account.getUsername().equals("admin") && account.getPassword().equals("123456")) {
	%>
	<p>Chào! Admin</p>
	<%
		} else {
	%>
	<p>Sai User hoặc Password</p>
	<%
		}
	%>

</body>
</html>