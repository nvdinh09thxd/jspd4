<%@page import="java.util.ArrayList"%>
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
<a href="<%=request.getContextPath()%>/baihoclop/index.jsp">Upload ảnh</a>
<div>
	<% 
		ArrayList<String> arFileName = new ArrayList<>();
		if(session.getAttribute("arFileName") != null){
			arFileName = (ArrayList<String>) session.getAttribute("arFileName");
		}
		if(arFileName.size() > 0){
		for(String fileName: arFileName){
	%>
		<img alt="Không thể hiển thị được hình ảnh" src="<%=request.getContextPath()%>/uploads/<%=fileName %>">
	<%}
		}else{ %>
		<p>Không có hình ảnh nào!</p>
	<%} %>
</div>
</body>
</html>