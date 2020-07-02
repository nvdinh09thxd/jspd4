package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/DeleteSessionController")
public class DeleteSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteSessionController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//xoa mot gia tri session
		session.removeAttribute("listHoa");
		/*session.removeAttribute("age");
*/		//xoa tat ca doi tuong session 
		//session.invalidate();
//		session.setMaxInactiveInterval(10);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
