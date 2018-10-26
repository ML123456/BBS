package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PinglunDaoTest;

/**
 * @author MaLiang
 * @version 创建时间：Aug 31, 2017  10:05:27 PM
 * tags
 */
//3.0以上使用@WebServlet注解，web.xml不再是必须；"/PinglunDelete": url路径
@WebServlet("/PinglunDelete")
public class PinglunDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int pid=new Integer(request.getParameter("pid"));
		
		PinglunDaoTest.deletePid(pid);
		
		response.sendRedirect("myself/mycenter.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
