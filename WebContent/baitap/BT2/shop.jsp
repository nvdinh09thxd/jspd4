<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MUA HOA</title>
		<link href="<%=request.getContextPath()%>/baitap/BT2/css/reset.css"	rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/baitap/BT2/css/style.css"	rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="wrapper">
			<h2>Mua hoa</h2>
			<form action="<%=request.getContextPath()%>/xuly-muahoa" method="post">
				<label>ID:</label> <input type="text" name="id" /><br /> <br /> 
				<label>Tên:</label>	<input type="text" name="tenhoa" /><br /><br /> 
				<label>Số lượng:</label> <input type="text" name="soluong" /><br /><br /> 
				<label>Giá bán:</label> <input type="text" name="gia" /><br /><br />
				<input type="submit" value="Mua hoa" />
			</form>
			<%
				String err = request.getParameter("err");
				String msg = request.getParameter("msg");
				if ("0".equals(err)) {
					out.print("<p style='color: red'>Vui long nhap day du thong tin vao!</p>");
				} else if ("1".equals(err)) {
					out.print("<p style='color: red'>Nhập sai định dạng số!</p>");
				}
				if ("1".equals(msg)) {
					out.print("<p style='color: green'>Da mua thanh cong!</p>");
				}
			%>
			<a href="<%=request.getContextPath()%>/baitap/BT2/basket.jsp"><button>Xem
					danh sách hoa đã mua</button></a>
		</div>
	</body>
</html>