<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File</title>
</head>
<body>
	<h1>Upload File</h1>
	<form action="<%=request.getContextPath()%>/addFile" method="post" enctype="multipart/form-data">
		Name: <input type="text" name="username" value="" /><br /><br />
		Avatar: <input type="file" name="avatar" value="" /><br /><br />
		
		<input type="submit" name="submit" value="Upload File" />
	</form>
</body>
</html>