package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Fatie;
import entity.User;
import service.FatieDaoTest;

/**
 * @author MaLiang
 * @version 创建时间：Aug 31, 2017 5:00:59 PM tags
 */
// 3.0以上使用@WebServlet注解，web.xml不再是必须；"/FatieUpdate": url路径
@WebServlet("/FatieUpdate")
public class FatieUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 存放构造的文件（图片）名
		File fullFile = null;
		// 存放标题和内容
		int fid = 0;
		String titles = null;
		String fcontent = null;

		HttpSession session = request.getSession();
		int userid = ((User) session.getAttribute("user")).getUserid();

		Fatie fatie = new Fatie();

		/**
		 * 将头像上传保存到相应目录
		 * 
		 */
		// 获取当前项目目录
		String pa = getServletContext().getRealPath("/");
		pa = pa.substring(0, pa.indexOf("\\.")).replace("\\", "/");
		String th = request.getContextPath().replace("\\", "/");

		System.out.println(pa + th);
		String uploadPath = (pa + th) + "/WebContent/uploda_Fatie";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart == true) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
				Iterator<FileItem> itr = items.iterator();

				// 改写格式
				Date date = new Date();
				String time = date.toLocaleString();
				time = time.replace(" ", "_");
				time = time.replace("-", "_");
				time = time.replace(":", "_");

				while (itr.hasNext()) {// 依次处理每个文件
					FileItem item = (FileItem) itr.next();
					String fileName = item.getName();// 获得文件名，包括路径
					if (fileName != null) {

						fullFile = new File(time + "_id" + userid + "_" + item.getName());
						File savedFile = new File(uploadPath, fullFile.getName());
						item.write(savedFile);
					}
					// 检查是一个普通的表单域还是File组件（true是普通表单）
					if (item.isFormField()) {
						// 检查表单属性
						if ("fid".equals(item.getFieldName())) {
							fid = new Integer(item.getString());
						}
						if ("titles".equals(item.getFieldName())) {
							titles = new String(item.getString().getBytes("iso-8859-1"), "UTF-8");
						}
						if ("fcontent".equals(item.getFieldName())) {
							fcontent = new String(item.getString().getBytes("iso-8859-1"), "UTF-8");
						}
					}
				}

				System.out.println("上传成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("enctype必须是 multipart/form-data");
		}

		/* 将发帖的图片信息插入数据库 */
		fatie.setFid(fid);
		fatie.setTitles(titles);
		fatie.setFcontent(fcontent);
		fatie.setPhoto(fullFile.getName());

		FatieDaoTest.update(fatie);

		response.sendRedirect("myself/mycenter.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
