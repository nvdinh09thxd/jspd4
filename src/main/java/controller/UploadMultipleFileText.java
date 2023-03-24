package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/text")
public class UploadMultipleFileText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadMultipleFileText() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/baihoclop/upload-multiple/text.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if (!item.isFormField()) {
						String fileName = item.getName();
						String root = getServletContext().getRealPath("/");
						File path = new File(root + "/uploads");
						if (!path.exists()) {
							path.mkdirs();
						}
						File uploadedFile = new File(path + File.separator + fileName);
						if (fileName != "") {
							item.write(uploadedFile);
						} else {
							out.println("file not found");
						}
						out.println("<h6>File Uploaded Successfully....:" + uploadedFile.getAbsolutePath() + "</h6>");
					} else {
						if(item.getFieldName().equals("name")) {
							String name = item.getString();
							out.println("<h2>Name: " + name + "</h2><br>");
						}
						if(item.getFieldName().equals("pass")) {
							String pass = item.getString();
							out.println("<h2>Pass: " + pass + "</h2><br>");
						}
					}
				}
			} catch (FileUploadException e) {
				out.println(e);
			} catch (Exception e) {
				out.println(e);
			}
		} else {
			out.println("Not Multipart");
		}
	}
}
