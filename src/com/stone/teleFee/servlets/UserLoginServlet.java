package com.stone.teleFee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stone.teleFee.beans.Info;
import com.stone.teleFee.beans.User;
import com.stone.teleFee.service.ComboService;
import com.stone.teleFee.service.ComboServiceImpl;
import com.stone.teleFee.service.UserService;
import com.stone.teleFee.service.UserServiceImpl;
import com.stone.teleFee.utils.CookieEncryptTool;


/**
 * Servlet implementation class UserLoginServlet
 * 
 * 登录
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//接收请求参数
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		
		//获取session
		HttpSession session = request.getSession();
		
		//判断电话、密码是否为空
		if(phone == null || "".equals(phone.trim())) {
			session.setAttribute("message", "电话输入有误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");//重定向
			return;
		}
		
		if(password == null || "".equals(password.trim())) {
			session.setAttribute("message", "密码输入有误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		//创建service对象
		UserService service = new UserServiceImpl();
		
		//调用service对象的checkservice方法对用户进行验证
		Integer result = service.checkUser(phone, password);
		
		//验证通过，跳转至主页index.jsp
		if(result!=0) {
			String login_phone = phone;
			session.setAttribute("login_phone", login_phone);//登录用户的电话
			rememberMe(rememberMe, phone, password, request, response);
			//获取账户金额、套餐信息
			Info info = service.getInfo(login_phone);
			session.setAttribute("user_money", info.getMoney());
			Integer combo_id = info.getCombo_id();
			session.setAttribute("combo_id", combo_id);
			ComboService ser = new ComboServiceImpl();
			String combo_name = ser.getComboName(combo_id);
			session.setAttribute("user_combo", combo_name);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			session.setAttribute("message", "账号或密码错误！");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
	}
	
	//记住手机号和密码
	private void rememberMe(String rememberMe, String phone, String password, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if ("true".equals(rememberMe)) {
			// 记住手机号及密码
			Cookie cookie = new Cookie("COOKIE_APPLICANTPHONE",
					CookieEncryptTool.encodeBase64(phone));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);

			cookie = new Cookie("COOKIE_APPLICANTPWD",
					CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			// 将手机号及密码Cookie清空
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("COOKIE_APPLICANTPHONE".equals(cookie.getName())
							|| "COOKIE_APPLICANTPWD".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
		
	}

}
