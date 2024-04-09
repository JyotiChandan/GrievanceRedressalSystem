package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otz.bean.AdminBean;
import com.otz.bean.ComplaintBean;
import com.otz.bean.UserBean;
import com.otz.model.ComplaintDao;
import com.otz.model.UserDao;

/**
 * Servlet implementation class User
 */
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
//		String username=(String)session.getAttribute("username");  
//		String password=(String)session.getAttribute("password");  
		String action = request.getParameter("action");
//		System.out.println(username);
//		System.out.println(password);
		System.out.println(action);
		PrintWriter out = response.getWriter();

		if (action.equals("get_complains_lists")) {
			ComplaintDao lists = new ComplaintDao();
			List<ComplaintBean> Complaint_Type_lists = lists.get_Complaint_Type();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(Complaint_Type_lists);
			out.print(JSONObject);
		} else if (action.equals("get_complains_catagory_lists")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ComplaintDao lists = new ComplaintDao();
			List<ComplaintBean> Complaint_catagory_Type_lists = lists.get_Complaint_catagory_Type_list(id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(Complaint_catagory_Type_lists);
			out.print(JSONObject);
		} else if (action.equals("set_complaint")) {
			String username = (String) session.getAttribute("username");
			String password = (String) session.getAttribute("password");
			UserDao user = new UserDao();
			int u_id = user.get_user_id(username);
			String token = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			ComplaintBean temp = new ComplaintBean();
			temp.setU_id(u_id);
			temp.setMobile(request.getParameter("txtmobile"));
			temp.setC_Id(Integer.parseInt(request.getParameter("txtcomplaint")));
			temp.setCat_Id(Integer.parseInt(request.getParameter("txtcomplaintcatagory")));
			temp.setComp_Address(request.getParameter("txtaddress"));
			temp.setComp_Pincode(request.getParameter("txtpincode"));
			temp.setComp_desc(request.getParameter("txtconcerns"));
			temp.setScreenshot(request.getParameter("txtphoto"));
			temp.setToken(token);
			ComplaintDao complaint = new ComplaintDao();
			int status = complaint.set_complaint2(temp);
			if(status > 0) {
				out.print(token);
			}
			
		} else if (action.equals("get_All_Complaint")) {
			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
			UserDao user = new UserDao();
			int u_id = user.get_user_id(username);
			System.out.println(u_id);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_complaints(u_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		} else if (action.equals("get_All_Resolved_Complains")) {
			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
			UserDao user = new UserDao();
			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_resolved_complaints(u_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		} else if (action.equals("get_All_Pending_Complains")) {
			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
			UserDao user = new UserDao();
			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_Pending_complaints(u_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		} else if (action.equals("get_All_Rejected_Complains")) {
			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
			UserDao user = new UserDao();
			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_Rejected_complaints(u_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		} else if (action.equals("get_All_Process_Complains")) {
			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
			UserDao user = new UserDao();
			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_All_Process_Complains(u_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		} else if (action.equals("submit_feedback")) {
			int s = 0;
			String username = (String) session.getAttribute("username");
			String token = request.getParameter("txttoken");
			String Explanation = request.getParameter("txtexplanation");
			ComplaintDao c = new ComplaintDao();
			int status = c.token_verification(token);
			if (status > 0) {
				UserDao u = new UserDao();
				int u_id = u.get_user_id(username);
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(u_id);
				temp.setToken(token);
				temp.setFeedback(Explanation);
				s = c.set_feedback(temp);
			}
			if (s > 0) {
				out.print(s);
			}
		} else if (action.equals("new_user_registration")) {
			int status = 0;
			String name = request.getParameter("Name");
			String UserName = request.getParameter("UserName");
			String Mobile = request.getParameter("Mobile");
			String Address = request.getParameter("Address");
			String Pincode = request.getParameter("Pincode");
			String Password = request.getParameter("Password");
			UserBean u = new UserBean();
			u.setName(name);
			u.setUsername(UserName);
			u.setMobile(Mobile);
			u.setAddress(Address);
			u.setPincode(Pincode);
			u.setPassword(Password);
			UserDao user = new UserDao();
			status = user.setNewUser(u);
			out.print(status);
		} else if (action.equals("get_All_Pending_Complains_admin")) {
			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
			UserDao user = new UserDao();
			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_Pending_complaints_admin();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		} else if (action.equals("get_All_Process_Complains_admin")) {
//			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
//			UserDao user = new UserDao();
//			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_All_Process_Complains_admin();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		}else if (action.equals("get_All_Rejected_Complains_admin")) {
//			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
//			UserDao user = new UserDao();
//			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_Rejected_complaints_admin();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		}else if (action.equals("get_All_Resolved_Complains_admin")) {
//			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
//			UserDao user = new UserDao();
//			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_resolved_complaints_admin();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		}
		else if (action.equals("get_All_Revert_Complains_admin")) {
//			String username = (String) session.getAttribute("username");
//			String password=(String)session.getAttribute("password"); 
//			UserDao user = new UserDao();
//			int u_id = user.get_user_id(username);
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_All_Revert_Complains_admin();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		}else if (action.equals("get_All_Complaint_admin")) {
			ComplaintDao complaint = new ComplaintDao();
			List<ComplaintBean> complaintlist = complaint.get_all_complaints_admin();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(complaintlist);
			out.print(JSONObject);
		}else if (action.equals("pendingcomplaintcount")) {
			String username = (String) session.getAttribute("username");
			UserDao u=new UserDao();
			int u_id = u.get_user_id(username);
			int status=u.pendingcomplaintcount(u_id);
			out.print(status);
		}else if (action.equals("successcomplaintcount")) {
		String username = (String) session.getAttribute("username");
		UserDao u=new UserDao();
		int u_id = u.get_user_id(username);
		int status=u.successcomplaintcount(u_id);
		out.print(status);
	}else if (action.equals("processcomplaintcount")) {
		String username = (String) session.getAttribute("username");
		UserDao u=new UserDao();
		int u_id = u.get_user_id(username);
		int status=u.processcomplaintcount(u_id);
		out.print(status);
	}else if (action.equals("rejectcomplaintcount")) {
		String username = (String) session.getAttribute("username");
		UserDao u=new UserDao();
		int u_id = u.get_user_id(username);
		int status=u.rejectcomplaintcount(u_id);
		out.print(status);
	}

	}

}
