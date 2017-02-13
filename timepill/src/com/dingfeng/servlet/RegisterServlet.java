package com.dingfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dingfeng.bean.LoginBean;
import com.dingfeng.dao.RegisterDao;
import com.dingfeng.utils.MD5;

public class RegisterServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equals("registerUser")){
			this.registerUser(request, response);
		}
		if(method.equals("checkEmail")){
			this.checkEmail(request, response);
		}
	}
	
	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickName = request.getParameter("nickName");
		String Email = request.getParameter("Email");
		String passWord = request.getParameter("passWord");
		LoginBean user = new LoginBean();
		user.setAccountName(Email);
		user.setEmail(Email);
		user.setNickName(nickName);
		user.setPassWord(MD5.getMD5(Email, passWord));
		int back = new RegisterDao().addUser(user);
		System.out.println(back);
		request.setAttribute("back1", back);
		response.sendRedirect("jsp/register.jsp");
	}
	
	public void checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String Email = request.getParameter("Email");
		int back = new RegisterDao().checkEmail(Email);	
		PrintWriter out = response.getWriter();
		out.println(back);
		out.flush();
		out.close();
	}

}
