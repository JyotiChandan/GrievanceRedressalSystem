package com.otz.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otz.bean.UserBean;
import com.otz.model.UserDao;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String Name=request.getParameter("Name");
		String UserName=request.getParameter("UserName");
		String Mobile=request.getParameter("Mobile");
		String Password=request.getParameter("Password");
		
		UserBean u=new UserBean();
		u.setName(Name);
		u.setUsername(UserName);
		u.setMobile(Mobile);
		u.setPassword(Password);
		
		UserDao obj=new UserDao();
		int status=obj.userRegistration(u);
		if(status > 0) {
			request.getRequestDispatcher("EmailSendingServlet").forward(request, response);  
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("UserRegistration.jsp");
			rd.forward(request, response);
		}
		
	}

}
