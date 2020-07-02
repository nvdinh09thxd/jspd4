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

public class MuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Hoa> listHoa = new ArrayList<>();

	public MuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String load = request.getParameter("load");
		if ("xem".equals(load)) {
			session.setAttribute("listHoa", listHoa);
			response.sendRedirect(request.getContextPath() + "/baihoclop/xemhoa.jsp");
		} else if ("xoa".equals(load)) {
			listHoa.clear();
			session.setAttribute("listHoa", listHoa);
			response.sendRedirect(request.getContextPath() + "/baihoclop/xemhoa.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("baihoclop/muahoa.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String tenHoa = request.getParameter("tenhoa");
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		float gia = Float.parseFloat(request.getParameter("gia"));
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

		response.sendRedirect(request.getContextPath() + "/xu-ly-mua-hoa");
	}
}
