<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>UPLOAD</title>
		<link href="<%=request.getContextPath()%>/baitap/BT3/css/reset.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/baitap/BT3/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="wrapper">
			<h1>Upload ảnh</h1>
			<form action="<%=request.getContextPath()%>/xu-ly-upload" method="post"	enctype="multipart/form-data">
				<label>Hình ảnh:</label>
				<input type="file" name="avatar" value="" /><br />
				<input type="submit" name="submit" value="Up hình" />
			</form>
			<%
				String msg = request.getParameter("msg");
				if("0".equals(msg)){
					out.print("<p style='color: red'>Vui long chon hinh anh!</p>");
				} else if("1".equals(msg)) {
					String link = request.getParameter("link");
					out.print("<p style='color: green'>Da up thanh cong!</p>");
					out.print("<p style='color: green'>Đường dẫn hình ảnh: "+ link.replace("-", "\\") +"</p>");
				}
			%>
		</div>
	</body>
</html>