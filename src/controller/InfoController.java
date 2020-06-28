package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*@WebServlet("/info")*/
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/baihoclop/inputinfo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// khoi tao gia tri session
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		// Luu lai gia tri session
		session.setAttribute("username", username);
		session.setAttribute("age", age);

		RequestDispatcher rd = request.getRequestDispatcher("/info.jsp");
		rd.forward(request, response);
	}
}
