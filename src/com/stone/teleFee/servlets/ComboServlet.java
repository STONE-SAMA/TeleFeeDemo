package com.stone.teleFee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stone.teleFee.beans.Combo;
import com.stone.teleFee.beans.comboPage;
import com.stone.teleFee.service.ComboService;
import com.stone.teleFee.service.ComboServiceImpl;
import com.stone.teleFee.service.RecordService;
import com.stone.teleFee.service.RecordServiceImpl;

/**
 * Servlet implementation class ComboServlet
 */
@WebServlet("/ComboServlet")
public class ComboServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public ComboServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		
		ComboService service = new ComboServiceImpl();
		HttpSession session = request.getSession();
		//得到当前登录用户的手机号
		String user_phone = (String) session.getAttribute("login_phone");
		
		if("select".equals(type)) {
			Integer comboID = Integer.parseInt(request.getParameter("id"));
			//更换套餐
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			Integer id = (Integer)session.getAttribute("combo_id");
			if(id==comboID) {
				out.print("<script language='javascript'>alert('套餐相同！');window.location.href='index.jsp';</script>");
			}else {
				//更改套餐
				service.changeCombo(user_phone, comboID);
				//消费记录中添加相应信息
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String time = sdf.format(now);
				String note = "套餐由 id = " + id + " 变更为 id = " + comboID;
				session.setAttribute("combo_id", comboID);
				RecordService ser = new RecordServiceImpl();
				ser.addRecord(user_phone, time, note);
				out.print("<script language='javascript'>alert('已更换套餐');window.location.href='index.jsp';</script>");
				String combo_name = service.getComboName(comboID);
				session.setAttribute("user_combo", combo_name);
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			out.flush();
			
//			Combo combo = service.getComboByID(comboID);
//			request.setAttribute("combo", combo);
//			request.getRequestDispatcher("include_combo.jsp").forward(request, response);
		}else if("pageList".equals(type)) {
			String pageNo = request.getParameter("pageNo");
			if(pageNo == null || "".equals(pageNo))
				pageNo = "1";
			comboPage pagination = new comboPage(2, Integer.parseInt(pageNo));
			request.setAttribute("pagination", pagination);
			request.getRequestDispatcher("include_combo.jsp").include(request, response);
		}
		
	}

}
