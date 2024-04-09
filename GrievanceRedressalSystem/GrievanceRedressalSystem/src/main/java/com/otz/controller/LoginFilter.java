package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.otz.bean.AdminBean;
import com.otz.model.LoginDao;

/**
 * Servlet implementation class LoginFilter
 */

public class LoginFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
		if(action.equals("adminLogin")) {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//System.out.println(username);
		//System.out.println(password);
		//System.out.println("1");
		AdminBean admin=new AdminBean();
		admin.setUsername(username);
		admin.setPassword(password);
		AdminBean admins=LoginDao.loginfilter(admin);
		
		session.setAttribute("username",admins.getUsername());
		session.setAttribute("password",admins.getPassword()); 
		session.setAttribute("user_image",admins.getImg_profile()); 
		out.print(admins.getRole_id());
		}
	}

}
