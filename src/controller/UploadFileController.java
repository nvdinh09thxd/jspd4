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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/upload-file")
@MultipartConfig // thêm anotation này để báo cho server biết có lấy thông tin khi upload file
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "uploads";

	public UploadFileController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/baihoclop/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// Lấy những thông tin không phải là file
		String hoten = request.getParameter("hoten");
		int tuoi = Integer.parseInt(request.getParameter("tuoi"));
		String chieucao = request.getParameter("chieucao");

		// out.print("Họ tên: " + hoten + "<br />");
		// out.print("Tuổi: " + tuoi + "<br />");
		// out.print("Chiều cao: " + chieucao + "<br />");

		// Lấy thông tin file
		Part filePart = request.getPart("hinhanh");
		String fileName = filePart.getSubmittedFileName();
		// long fileSize = filePart.getSize();
		// String fileType = filePart.getContentType();
		// String fileNameInput = filePart.getName();
		// out.print("File Name: " + fileName + "<br />");
		// out.print("File Size: " + fileSize + "<br />");
		// out.print("File Type: " + fileType + "<br />");
		// out.print("File Name Input: " + fileNameInput + "<br />");

		// Upload File
		// request.getContextPath(); //Đường dẫn tương đối
		String contextRoot = request.getServletContext().getRealPath("");// đường dẫn gốc của dự án
		// out.print("contextRoot: " + contextRoot);
		// Tạo đường dẫn thư mục upload
		String dirUpload = contextRoot + DIR_UPLOAD;
		File saveDir = new File(dirUpload);
		// Nếu chưa tồn tại thư mục thì tạo ra
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		// Tạo đường dẫn file
		String filePath = dirUpload + File.separator + fileName;
		filePart.write(filePath);
		out.print("Upload File thành công, xem tại path: " + dirUpload);
		
		// Tìm hiểu thêm: upload nhiều file, đổi tên file, kiểm tra typefile, sizefile
		// Lưu session là một ArrayList gồm nhiều file, rồi lấy ra ArrayList gồm nhiều file và hiển thị
		
		
		// Tạo đối tượng session
		HttpSession session = request.getSession();
		
		// Lưu lại thông tin session
		session.setAttribute("fileName", fileName);
		// Tự động xóa tất cả thông tin session sau 30 phút
		// Nếu chạy từ file servlet thì sẽ tính thời gian timeout set ở đây
		// còn nếu chạy từ file jsp thì sẽ tính thời gian timeout sẽ lấy ở file web.xml
		session.setMaxInactiveInterval(60*30);// thời gian tính bằng giây
		response.sendRedirect(request.getContextPath()+"/baihoclop/list-upload.jsp");
	}

}
