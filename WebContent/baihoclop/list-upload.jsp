<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Upload</title>
</head>
<body>
<h1>Danh sách các hình ảnh upload</h1>
<div>
	<%
		String fileName = (String) session.getAttribute("fileName");
	%>
	<img alt="Không thể hiển thị được hình ảnh" src="<%=request.getContextPath()%>/uploads/<%=fileName %>">
</div>
</body>
</html>