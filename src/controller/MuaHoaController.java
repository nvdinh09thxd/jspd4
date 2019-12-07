package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Hoa;

public class MuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Hoa> listHoa = new ArrayList<Hoa>();

	public MuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/baitap/BT2/shop.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strid = request.getParameter("id");
		String tenHoa = request.getParameter("ten");
		String strsoLuong = request.getParameter("soluong");
		String strgia = request.getParameter("gia");
		if ("".equals(strid) || "".equals(tenHoa) || "".equals(strsoLuong) || "".equals(strgia)) {
			response.sendRedirect(request.getContextPath() + "/baitap/BT2/shop.jsp?msg=0");
		} else {
			int id = 0;
			int soLuong = 0;
			int gia = 0;
			try {
				id = Integer.parseInt(strid);
				soLuong = Integer.parseInt(strsoLuong);
				gia = Integer.parseInt(strgia);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/baitap/BT2/shop.jsp?msg=2");
				return;
			}
			boolean check = false;
			for (Hoa objHoa : listHoa) {
				if (objHoa.getId() == id) {
					objHoa.setSoLuong(objHoa.getSoLuong() + soLuong);
					check = true;
				}
			}
			if (!check) {
				Hoa hoa = new Hoa(id, tenHoa, soLuong, gia);
				listHoa.add(hoa);
			}

			HttpSession session = request.getSession();
			session.setAttribute("listHoa", listHoa);

			response.sendRedirect(request.getContextPath() + "/baitap/BT2/shop.jsp?msg=1");
		}
	}
}
