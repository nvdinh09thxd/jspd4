package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/remove-session")
public class DeleteSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteSessionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 1. Xóa 1 biến trong session
		session.removeAttribute("fileName");
		response.getWriter().print("Xóa session thành công!");
		// 2. Xóa tất cả các biến trong session
		// session.invalidate();
		// response.getWriter().print("Đã xóa tất cả các biến trong session!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
