package com.otz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.otz.bean.RoleBean;

public class RoleDao {

	public List<RoleBean> getRoles() {
		// TODO Auto-generated method stub
		ArrayList<RoleBean> roleslist = new ArrayList<RoleBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Role";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RoleBean role = new RoleBean();
				role.setId(rs.getInt("Id"));
				role.setName(rs.getString("Name"));
				role.setStatus(rs.getInt("Status"));
				roleslist.add(role);
			}
			con.close();
			ps.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return roleslist;
	}

	public int setRole(RoleBean setdata) {
		// TODO Auto-generated method stub
		int temp=0;
		try {
		Connection con=DBUtil.getconnection();
		String sql="insert into Role(name,status) values(?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, setdata.getName());
		ps.setInt(2, setdata.getStatus());
		temp=ps.executeUpdate();
		ps.close();
		con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<RoleBean> getRole(int id) {
		// TODO Auto-generated method stub
		ArrayList<RoleBean> roleslist = new ArrayList<RoleBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Role where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RoleBean role = new RoleBean();
				role.setId(rs.getInt("Id"));
				role.setName(rs.getString("Name"));
				role.setStatus(rs.getInt("Status"));
				roleslist.add(role);
			}
			con.close();
			ps.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return roleslist;
	}

	public int updaterole(RoleBean role) {
		// TODO Auto-generated method stub
		int temp=0;
		try {
			Connection con=DBUtil.getconnection();
			String sql="update role set name=?,Status=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, role.getName());
			ps.setInt(2, role.getStatus());
			ps.setInt(3, role.getId());
			temp=ps.executeUpdate();
			ps.close();
			con.close();
			}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int deleterole(RoleBean role) {
		// TODO Auto-generated method stub
		int temp=0;
		try {
			Connection con=DBUtil.getconnection();
			String sql="delete from role where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, role.getId());
			temp=ps.executeUpdate();
			ps.close();
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	
//	public List<RoleBean> getAllRole() {
//		// TODO Auto-generated method stub
//		ArrayList<RoleBean> roleslist = new ArrayList<RoleBean>();
//		try {
//			Connection con = DBUtil.getconnection();
//			String sql ="select * from uld inner join role on uld.id=role.id";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//				
//			}
//		}catch(Exception ex) {
//			ex.printStackTrace();
//			
//		}
//		return null;
//	}

}
