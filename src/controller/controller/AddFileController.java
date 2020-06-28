package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/addFile")
@MultipartConfig // annotation, phai có dòng này thông báo cho servlet biết mình vừa upload vừa
					// lấy thông tin, nếu không có dòng này, thì thông tin file sẽ null
public class AddFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "UPLOAD";

	public AddFileController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/baihoclop/upload.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		// xử lý upload file
		// thông tin file
		Part filePart = request.getPart("avatar");
		// lấy tên file
		String fileName = filePart.getSubmittedFileName();
		// kiểm tra nếu có chọn file thì mới upload
		if (!"".equals(fileName)) {

			String appPath = request.getServletContext().getRealPath("");
			// tạo đường dẫn thư mục chứa file
			String dirPath = appPath + DIR_UPLOAD;
			File saveDir = new File(dirPath);
			// tạo thư mục nếu chưa có
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			// đường dẫn file
			String filePath = dirPath + File.separator + fileName;
			// ghi file
			filePart.write(filePath);
			out.print("Đã upload file thành công với đường dẫn file: " + filePath);
			System.out.println("username: " + username);
		} else {
			System.out.println("Chưa chọn file");
		}
	}
}
