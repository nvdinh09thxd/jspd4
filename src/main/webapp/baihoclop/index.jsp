<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Form | VinaEnter Edu</title>
<link href="<%=request.getContextPath() %>/baihoclop/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<h1>Thông tin Mr.VinaEnter</h1>
		<form action="<%=request.getContextPath() %>/upload-file" method="post" enctype="multipart/form-data">
		<!-- Phải có method="post" va có thêm thuộc tính enctype="multipart/form-data" -->
			<p>
				<label>Họ tên:</label> <input type="text" name="hoten" id="hoten" value="VinaEnter Edu" />
			</p>
			<p>
				<label>Tuổi:</label> <input type="text" name="tuoi" id="tuoi" value="100" />
			</p>
			<p>
				<label>Chiều cao:</label> <input type="text" name="chieucao" id="chieucao" value="1m75" />
			</p>
			<p>
				<label>Hình ảnh:</label> <input type="file" name="hinhanh" id="hinhanh" />
			</p>
			<p>
				<input type="submit" name="submit" id="submit" value="Gửi thông tin" />
			</p>
		</form>
		
		<div class="button">
			<a href="<%=request.getContextPath()%>/baihoclop/list-upload.jsp">Xem những hình ảnh đã upload</a>
			<%
				String msg = (String) request.getParameter("msg");
				String err = (String) request.getParameter("err");
				if("1".equals(msg)) out.print("<p style='color: green'>Đã upload file thành công!</p>");
				if("0".equals(err)) out.print("<p style='color: red'>Vui lòng chọn file!</p>");
			%>
		</div>
	</div>
</body>
</html>
