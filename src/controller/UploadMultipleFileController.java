package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload-multiple")
public class UploadMultipleFileController extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "D:/abc";
	private static final long serialVersionUID = 1L;

	public UploadMultipleFileController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/baihoclop/upload-multiple/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File saveDir = new File(UPLOAD_DIRECTORY);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						name = rename(name);
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}
				}
				request.setAttribute("message", "File uploaded successfully.");
			} catch (Exception ex) {
				request.setAttribute("message", "File upload failed due to : " + ex);
			}
		} else {
			request.setAttribute("message", "Sorry this servlet only handles file upload request.");
		}
		String name = request.getParameter("name");
		System.out.println("name: " + name);
		request.getRequestDispatcher("/baihoclop/upload-multiple/result.jsp").forward(request, response);
	}

	public static String rename(String fileName) {
		String nameFile = "";
		if (!fileName.isEmpty()) {
			String[] arrImg = fileName.split("\\.");
			String duoiFileImg = arrImg[arrImg.length - 1];

			for (int i = 0; i < (arrImg.length - 1); i++) {
				if (i == 0) {
					nameFile = arrImg[i];
				} else {
					nameFile += "-" + arrImg[i];
				}
			}
			nameFile = nameFile + "-" + System.nanoTime() + "." + duoiFileImg;
		}
		return nameFile;
	}

}
