//package com.otz.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.otz.bean.RoleBean;
//import com.otz.model.RoleDao;
//
///**
// * Servlet implementation class Role
// */
//public class Role extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Role() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		PrintWriter out=response.getWriter();
//		String action=request.getParameter("action");
//		System.out.println(action);
//		if(action.equals("fetchroles")) {
//			RoleDao role=new RoleDao();
//			List<RoleBean> roleslist=role.getRoles();
//			GsonBuilder gsonBuilder = new GsonBuilder();
//			Gson gson = gsonBuilder.create();
//			String JSONObject = gson.toJson(roleslist);
//			out.print(JSONObject);
//			
//		}else if(action.equals("addrole")) {
//			String name=request.getParameter("name");
//			int status=Integer.parseInt(request.getParameter("status"));
//			System.out.println(name);
//			System.out.println(status);
//			RoleBean setdata =new RoleBean();
//			setdata.setName(name);
//			setdata.setStatus(status);
//			RoleDao set=new RoleDao();
//			int temp=set.setRole(setdata);
//			out.print(temp);
//			
//		}else if(action.equals("fetchrole")) {
//			int id=Integer.parseInt(request.getParameter("id"));
//			RoleDao role=new RoleDao();
//			List<RoleBean> rolelist=role.getRole(id);
//			GsonBuilder gsonBuilder = new GsonBuilder();
//			Gson gson = gsonBuilder.create();
//			String JSONObject = gson.toJson(rolelist);
//			out.print(JSONObject);
//			
//		}else if(action.equals("updaterole")) {
//			String name=request.getParameter("name2");
//			int status=Integer.parseInt(request.getParameter("status2"));
//			int id=Integer.parseInt(request.getParameter("roleId"));
//			RoleBean role=new RoleBean();
//			role.setName(name);
//			role.setStatus(status);
//			role.setId(id);
//			RoleDao update=new RoleDao();
//			int temp=update.updaterole(role);
//			out.print(temp);
//		}else if(action.equals("deleterole")) {
//			int id=Integer.parseInt(request.getParameter("id"));
//			RoleBean role=new RoleBean();
//			role.setId(id);
//			RoleDao delete=new RoleDao();
//			int status=delete.deleterole(role);
//			out.print(status);
//		}
//	}
//
//}
