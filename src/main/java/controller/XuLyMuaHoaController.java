package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Hoa;

public class XuLyMuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Hoa> listHoa = new ArrayList<>();

	public XuLyMuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("baitap/BT2/shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		String tenHoa = request.getParameter("tenhoa");
		String soLuongStr = request.getParameter("soluong");
		String giaStr = request.getParameter("gia");
		int id, soLuong;
		float gia;
		// Nếu chưa nhập một trường nào đó thì chuyển hướng về và thông báo lỗi
		if (idStr == "" || tenHoa == "" || soLuongStr == "" || giaStr == "") {
			response.sendRedirect(request.getContextPath() + "/baitap/BT2/shop.jsp?err=0");
			return;
		}
		// Parse các giá trị string sang kiểu số
		try {
			id = Integer.parseInt(idStr);
			soLuong = Integer.parseInt(soLuongStr);
			gia = Float.parseFloat(giaStr);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/baitap/BT2/shop.jsp?err=1");
			return;
		}
		// Xét điều kiện: Nếu đã tồn tại id hoa thì tăng số lượng chứ không thêm mới phần tử
		boolean check = false;
		for (Hoa objHoa : listHoa) {
			if (objHoa.getId() == id) {
				objHoa.setSoLuong(soLuong + objHoa.getSoLuong());
				check = true;
			}
		}
		if (!check) {
			listHoa.add(new Hoa(id, tenHoa, soLuong, gia));
		}
		session.setAttribute("listHoa", listHoa);
		response.sendRedirect(request.getContextPath() + "/baitap/BT2/shop.jsp?msg=1");
	}
}
