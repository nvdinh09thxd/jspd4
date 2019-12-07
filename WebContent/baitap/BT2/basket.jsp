<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Hoa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Xem Hoa</title>
	<style>
		table {
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
		
		td {
			//border: 1px solid red;
			text-align: center;
		}
	</style>
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
		ArrayList<Hoa> listHoa = (ArrayList<Hoa>) session.getAttribute("listHoa");
			int tongTien = 0;
			if (listHoa!=null && listHoa.size() > 0) {
	%>
	<table>
		<tr>
			<th>Tên sản phẩm</th>
			<th>Giá</th>
			<th>Số lượng</th>
			<th>Thành tiền</th>
		</tr>
		<%
			for (int i = 0; i < listHoa.size(); i++) {
					tongTien += listHoa.get(i).tongTien();
		%>
		<tr>
			<td style="text-decoration: underline; color: #95677C; width: 330px"><%=listHoa.get(i).getTenHoa()%></td>
			<td style="width: 170px"><%=listHoa.get(i).getGia()%></td>
			<td>
				<input type="text" value="<%=listHoa.get(i).getSoLuong()%>" style="width: 150px" />
			</td>
			<td style="width: 250px"><%=listHoa.get(i).tongTien()%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="3" style="border: 1px solid red; text-align: right">Tổng tiền</td>
			<td style="border: 1px solid red"><%=tongTien%></td>
		</tr>
	</table>
	<%
		} else {
	%>
	<p>Danh sách trống</p>
	<%
		}
	%>
</body>
</html>