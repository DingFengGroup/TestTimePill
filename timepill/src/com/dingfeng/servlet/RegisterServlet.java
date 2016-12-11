package com.dingfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("!!!!!!!!!!!!!!!!!!!!!");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkPassword = request.getParameter("checkpassword");
		
		//判断两次输入的密码是否相同
		if(password.equals(checkPassword)){
			
			/*User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			UserInter userInter = new UserImpl();
			if(userInter.register(user)){
				JOptionPane.showMessageDialog(null, "注册成功！");
				response.sendRedirect("jsp/login.jsp");
			}
			else{
				JOptionPane.showMessageDialog(null, "注册失败！");
				response.sendRedirect("jsp/register.jsp");
			}*/
		}else{
			JOptionPane.showMessageDialog(null, "密码不一致");
			response.sendRedirect("jsp/register.jsp");
		}
	}

}
