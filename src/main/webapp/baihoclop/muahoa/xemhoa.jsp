<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="bean.Hoa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách hoa</title>
		<style>
			table, th, td {
				border: 1px solid gray;
			}
			
			table {
				border-collapse: collapse;
				width: 900px;
				margin: 10px auto;
			}
	
			th {
				background-color: #DEDEDE;
			}
		</style>
	</head>
	<body>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Hoa> listHoa = (ArrayList<Hoa>) session.getAttribute("listHoa");
			if (listHoa != null && listHoa.size() > 0) {
		%>
		<table>
			<tr>
				<th>Tên sản phẩm</th>
				<th>Giá</th>
				<th>Số lượng</th>
				<th>Tổng tiền</th>
			</tr>
			<%
				for (Hoa itemHoa: listHoa) {
			%>
			<tr>
				<td style="width: 330px"><%=itemHoa.getTenHoa()%></td>
				<td style="width: 170px"><%=itemHoa.getGia()%></td>
				<td><input type="text" value="<%=itemHoa.getSoLuong()%>" style="width: 150px" /></td>
				<td style="width: 250px"><%=itemHoa.tongTien()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="<%=request.getContextPath()%>/muahoa" title="">Mua hoa</a>
		<a href="<%=request.getContextPath()%>/muahoa?load=xoa" title="">Xóa hết</a>
		<%
			} else {
		%>
		<p>Không có danh sách hoa</p>
		<a href="<%=request.getContextPath()%>/muahoa" title="">Mua hoa</a>
		<%
			}
		%>
	
	</body>
</html>