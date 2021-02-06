package com.stone.teleFee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stone.teleFee.beans.recordPage;
import com.stone.teleFee.service.RecordService;
import com.stone.teleFee.service.RecordServiceImpl;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		
		HttpSession session = request.getSession();
		//得到当前登录用户的手机号
		String user_phone = (String) session.getAttribute("login_phone");
		
		RecordService service = new RecordServiceImpl();
		
		if("select".equals(type)) {
			//消费记录详情，未实现
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else if("pageList".equals(type)) {
			String pageNo = request.getParameter("pageNo");
			if(pageNo == null || "".equals(pageNo))
				pageNo = "1";
			recordPage pagination = new recordPage(2, Integer.parseInt(pageNo), user_phone);
			request.setAttribute("pagination", pagination);
			request.getRequestDispatcher("bill.jsp").include(request, response);
		}
	}

}
