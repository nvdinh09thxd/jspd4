<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mua hoa</title>
<link href="<%=request.getContextPath()%>/baihoclop/muahoa/css/reset.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/baihoclop/muahoa/css/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<h2>Mua hoa</h2>
		<form action="<%=request.getContextPath()%>/muahoa" method="post">
			<label>ID hoa:</label> 
			<input type="text" name="id" /><br /><br />
			<label>Tên hoa:</label> 
			<input type="text" name="tenhoa" /><br /><br />
			<label>Số lượng:</label> 
			<input type="text" name="soluong" /><br /><br />
			<br /> <label>Giá:</label> 
			<input type="text" name="gia" /><br /><br /> 
			<input type="submit" value="Mua hoa" />
		</form>
		<a href="<%=request.getContextPath()%>/muahoa?load=xem"
			title="">Xem kết quả</a>
	</div>
</body>
</html>