package com.dingfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingfeng.api.LoginApi;
import com.dingfeng.bean.LoginBean;
import com.dingfeng.manage.LoginManage;

public class LoginServlet  extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			this.doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
			PrintWriter out = resp.getWriter();
			String accountName = req.getParameter("accountName");
			String passWord = req.getParameter("passWord");
			System.err.println(accountName+"///"+passWord);
			LoginManage loginManage = new LoginManage();
			LoginBean loginBean = loginManage.login(accountName, passWord);
			if(loginBean.getAccountName() != null){
				req.getSession().setAttribute("loginBean", loginBean);
				resp.sendRedirect("jsp/success.jsp");
			}else{
				resp.sendRedirect("jsp/error.jsp");
			}
		}
}
