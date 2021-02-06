package com.stone.teleFee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stone.teleFee.beans.User;
import com.stone.teleFee.service.UserService;
import com.stone.teleFee.service.UserServiceImpl;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取表单参数
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//PrintWriter out = response.getWriter();
		
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		
		if(phone == null || "".equals(phone.trim())) {
			session.setAttribute("message", "电话输入有误");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;
		}
		
		if(name == null || "".equals(name.trim())) {
			session.setAttribute("message", "用户名输入有误");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;
		}
		
		if(password == null || "".equals(password.trim())) {
			session.setAttribute("message", "电话输入有误");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;
		}
		
		//验证验证码正确性以及手机号唯一性
		String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
		if(!sessionValidateCode.equals(verifyCode)) {
			session.setAttribute("message", "验证码输入错误");
//			out.print("<script type='text/javascript'>");
//			out.print("alert('验证码输入错误，请重新输入！');");
//			out.print("window.location='register.jsp';");
//			out.print("</script>");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;
		}else {
			UserService service = new UserServiceImpl();
			boolean result = service.isExist(phone);
			if(result) {
				//手机号已使用
				session.setAttribute("message", "该手机号已被使用");
				response.sendRedirect(request.getContextPath()+"/register.jsp");
				return;
			}else {
				//手机号未使用,写入数据库
				User user = new User();
				user.setName(name);
				user.setPhone(phone);
				user.setPassword(password);
				//调用service对象的saveUser方法将对象写入DB
				Integer flag = service.saveUser(user);
				//写入失败，则跳转到注册页面，重新注册
				if(flag < 0) {
					session.setAttribute("message", "注册失败！");
					response.sendRedirect(request.getContextPath()+"/register.jsp");
					return;
				}else {//注册成功
					//在tb_info中添加相应的默认信息
					service.addUserInfo(flag, phone);
					PrintWriter out = response.getWriter();
					out.print("<script language='javascript'>alert('注册成功！');window.location.href='register.jsp';</script>");
					response.sendRedirect(request.getContextPath()+"/login.jsp");
					out.flush();
				}
			}
		}
		
		
	}

}
