package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Pinglun;
import service.PinglunDaoTest;

/**
 * @author MaLiang
 * @version 创建时间：Aug 30, 2017  5:43:27 PM
 * tags
 */
//3.0以上使用@WebServlet注解，web.xml不再是必须；"/PinglunAdd": url路径
@WebServlet("/PinglunAdd")
public class PinglunAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Pinglun pinglun=new Pinglun();
		
		pinglun.setPcontent(request.getParameter("pinglun_m"));
		pinglun.setUserid(new Integer(request.getParameter("userid")));
		pinglun.setByid(new Integer(request.getParameter("byid")));
		
		System.out.println("评论");
		PinglunDaoTest.save(pinglun);
		
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
