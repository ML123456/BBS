package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FatieDaoTest;
import service.PinglunDaoTest;

/**
 * @author MaLiang
 * @version 创建时间：Aug 31, 2017  12:44:35 PM
 * tags
 */
//3.0以上使用@WebServlet注解，web.xml不再是必须；"/FatieDelete": url路径
@WebServlet("/FatieDelete")
public class FatieDelete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String fid=request.getParameter("fid");
		
		
		/*调用该方法删除发帖表的信息*/
		FatieDaoTest.delete(new Integer(fid));
		/*调用该方法删除该发帖表下面的评论信息*/
		PinglunDaoTest.delete(new Integer(fid));
		
		response.sendRedirect("myself/mycenter.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
