package com.stone.teleFee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stone.teleFee.service.UserService;
import com.stone.teleFee.service.UserServiceImpl;

/**
 * Servlet implementation class changePassServlet
 */
@WebServlet("/changePassServlet")
public class changePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//得到当前登录用户的手机号
		String user_phone = (String) session.getAttribute("login_phone");
		
		//接收请求参数
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("pwd1");
		//String pwd2 = request.getParameter("pwd2");
		
		if(oldPass == null || "".equals(oldPass.trim())) {
			session.setAttribute("message", "密码输入有误！");
			response.sendRedirect(request.getContextPath()+"/changePassword.jsp");//重定向
			return;
		}
		
		UserService service = new UserServiceImpl();
		
		//检验原密码是否正确
		boolean flag = service.checkPass(user_phone, oldPass);
		if(flag==false) {
			session.setAttribute("message", "原密码输入有误！");
			response.sendRedirect(request.getContextPath()+"/changePassword.jsp");//重定向
			return;
		}
		
		if(oldPass.equals(newPass)) {
			session.setAttribute("message", "新密码与原密码相同！");
			response.sendRedirect(request.getContextPath()+"/changePassword.jsp");//重定向
			return;
		}
		//设置新密码
		service.setNewPass(newPass, user_phone);
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}

}
