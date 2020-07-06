package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UploadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/baitap/BT3/upload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("avatar");
		String fileName = filePart.getSubmittedFileName();
		if (!"".equals(fileName)) {
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + "HinhAnh";
			File saveDir = new File(dirPath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			String portal = fileName.split("\\.")[0];
			String extra = fileName.split("\\.")[1];
			long time = System.currentTimeMillis();
			String filePath = dirPath + File.separator + portal + "_" + time + "." + extra;
			filePart.write(filePath);
			request.setAttribute("filePath", filePath);
			request.getRequestDispatcher("/baitap/BT3/upload.jsp?msg=1").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/baitap/BT3/upload.jsp?msg=0");
		}
	}
}
