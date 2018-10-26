package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.UserDaoTest;

/**
 * @author MaLiang
 * @version 创建时间：Aug 24, 2017 4:29:03 PM tags
 */
// 3.0以上使用@WebServlet注解，web.xml不再是必须；"/LoginServlet": url路径
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		/* 用户名 */
		String name = request.getParameter("name");
		/* 密码 */
		String pass = request.getParameter("pass");
		/* 确认密码 */
		String qr_pass = request.getParameter("qr_pass");
		/* 验证码 */
		String code = request.getParameter("code");

		HttpSession session = request.getSession();

		Map<Object, Object> map = new HashMap<>();
		Map<Object, Object> map_r = new HashMap<>();

		map_r.put("name", name);
		map_r.put("password", pass);

		/*2、在RequestScope2中，这样取得参数值： */
		Map<Object, Object> map2=new HashMap<>();
		if(null==name) {
			String[] queryStrings =request.getQueryString().split("&");  
	        String key ;  
	        String value ;  
	        for(String queryString : queryStrings){  
	            key = queryString.split("=")[0];  
	            value = queryString.split("=")[1];  
	              
	            value = URLDecoder.decode(value,"UTF-8");
	            map2.put(key, value);
	            System.out.println("11->:"+key+" : "+value);  
	        }
	        name=(String)map2.get("name2");
		}
		
		map = UserDaoTest.Login(name);
		/**
		 * 判断是登录还是注册,true是登录
		 */
		if (qr_pass == null) {
			if (name.equals(map.get("name")) && pass.equals(map.get("password"))
					&& code.equals(session.getAttribute("certCode"))) {

				System.out.println("注册到登录");
				User user = new User();
				user.setName(name);
				user.setPassword(pass);
				user.setUserid((int) map.get("userid"));

				session.setAttribute("user", user);

				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
		} else if (pass.equals(qr_pass) && code.equals(session.getAttribute("certCode"))) {

			UserDaoTest.insert(map_r);

			/*1、在RequestScope中修改URL */
			response.sendRedirect("LoginServlet?name2=" + URLEncoder.encode(name,"UTF-8") + "&pass=" + pass + "&code=" + code);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
