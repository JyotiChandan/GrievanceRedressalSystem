package com.otz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.otz.bean.AdminBean;
import com.otz.bean.UserBean;

public class LoginDao {
	public static AdminBean loginfilter(AdminBean admin) {
		ArrayList<AdminBean> adminlists = new ArrayList<AdminBean>();
		int status = 0;
//			System.out.print(admin.getUsername());
//			System.out.print(admin.getPassword());
			AdminBean u=new AdminBean();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from uld where UserName=? and Password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				u.setUsername(rs.getString("UserName"));
				u.setPassword(rs.getString("Password"));
				u.setRole_id(rs.getInt("Role_id"));
				u.setImg_profile(rs.getString("Image"));
//				adminlists.add(u);
			}
			
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}
}
