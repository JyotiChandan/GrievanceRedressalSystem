package com.otz.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.otz.bean.*;

public class UserDao {
	public static int loginfilter(UserBean user) {
		int status = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select Role_id from uld where UserName=? and Password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			rs.next();
			status = rs.getInt("Role_id");
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static boolean user(UserBean u) {
		boolean status = false;
		try {

			Connection con = DBUtil.getconnection();
			String sql = "select * from uld where UserName=? and Password=? and Role_id=1";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			ResultSet rs = stmt.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public int userRegistration(UserBean u) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "insert into uld (Name, Username, Mobile, Password) values (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getMobile());
			stmt.setString(4, u.getPassword());
			status = stmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public List<UserBean> getUsers(String username, String password) {
		ArrayList<UserBean> userslist = new ArrayList<UserBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from uld where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("Name"));
				user.setUsername(rs.getString("UserName"));
				user.setPassword(rs.getString("Password"));
				user.setMobile(rs.getString("Mobile"));
				user.setRole_id(rs.getInt("Role_id"));
				user.setAddress(rs.getString("Address"));
				user.setPincode(rs.getString("Pincode"));
				userslist.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userslist;
	}

	public static boolean admin(UserBean u) {
		boolean status = false;

		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from uld where UserName=? and Password=? and Role_id=2";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			ResultSet rs = stmt.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public List<TempBean> getAllUser() {
		ArrayList<TempBean> userslist = new ArrayList<TempBean>();
		try {
			int temp_id = 1;
			Connection con = DBUtil.getconnection();
			String sql = "select * from uld left join role on role.id=uld.role_id where uld.Role_id != ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, temp_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TempBean temp = new TempBean();
				temp.setId(rs.getInt("Id"));
				temp.setName(rs.getString("Name"));
				temp.setUsername(rs.getString("Username"));
				temp.setMobile(rs.getString("Mobile"));
				temp.setPassword(rs.getString("Password"));
				temp.setRole_id(rs.getInt("Role_id"));
				temp.setAddress(rs.getString("Address"));
				temp.setPincode(rs.getString("Pincode"));
				temp.setRoleName(rs.getString("role.name"));
				temp.setRoleStatus(rs.getString("Status"));
				userslist.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return userslist;
	}

	public List<UserBean> getUser(int id) {
		// TODO Auto-generated method stub
		ArrayList<UserBean> userlist = new ArrayList<UserBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from uld where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("Name"));
				user.setUsername(rs.getString("UserName"));
				user.setMobile(rs.getString("Mobile"));
				user.setPassword(rs.getString("Password"));
				user.setRole_id(rs.getInt("Role_id"));
				user.setAddress(rs.getString("Address"));
				user.setPincode(rs.getString("Pincode"));
				user.setStatus(rs.getInt("Status"));
				userlist.add(user);
			}
			con.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userlist;
	}

	public int setUserData(UserBean user) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update uld set name=?,username=?,mobile=?, password=?,role_id=?,address=?,pincode=?,status=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getRole_id());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPincode());
			ps.setInt(8, user.getStatus());
			ps.setInt(9, user.getId());
			temp = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int setNewUserData(UserBean user) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "insert into uld (Name, Username, Mobile, Password, Role_id, Address, Pincode, Status) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getRole_id());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPincode());
			ps.setInt(8, user.getStatus());
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int deleteuser(int id) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "DELETE FROM uld WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			temp = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int get_user_id(String username) {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select Id from uld where UserName=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			id = rs.getInt("Id");
			System.out.println(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}

	public List<TempBean> getAllUser(int customer_id) {
		// TODO Auto-generated method stub
		ArrayList<TempBean> userslist = new ArrayList<TempBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from uld where Role_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, customer_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TempBean temp = new TempBean();
				temp.setId(rs.getInt("Id"));
				temp.setName(rs.getString("Name"));
				temp.setUsername(rs.getString("Username"));
				temp.setMobile(rs.getString("Mobile"));
				temp.setPassword(rs.getString("Password"));
//				temp.setRole_id(rs.getInt("Role_id"));
				temp.setAddress(rs.getString("Address"));
				temp.setPincode(rs.getString("Pincode"));
//				temp.setRoleName(rs.getString("role.name"));
				temp.setRoleStatus(rs.getString("Status"));
				userslist.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return userslist;
	}

	public int setNewUser(UserBean u) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "insert into uld (Name, Username, Mobile, Password, Address, Pincode) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getMobile());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getRole_id());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getPincode());
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<UserBean> get_all_engineers(String pincode) {
		// TODO Auto-generated method stub
		ArrayList<UserBean> lists = new ArrayList<UserBean>();
		try {
			System.out.println("1");
			int status = 1;
			int roleid = 3;
			Connection con = DBUtil.getconnection();
			String sql = "select Id,Name,UserName,Pincode from uld where Pincode=? and Status=? and Role_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pincode);
			ps.setInt(2, status);
			ps.setInt(3, roleid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				System.out.println("hii");
				UserBean temp = new UserBean();
				temp.setId(rs.getInt("Id"));
				temp.setName(rs.getString("Name"));
				temp.setUsername(rs.getString("UserName"));
				temp.setPincode(rs.getString("Pincode"));
				lists.add(temp);
				
			}
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(lists);
		return lists;
	}

	public List<UserBean> fetch_all_engineers() {
		// TODO Auto-generated method stub
		ArrayList<UserBean> lists = new ArrayList<UserBean>();
		try {
			int status = 1;
			int roleid = 3;
			Connection con = DBUtil.getconnection();
			String sql = "select Id,Name,UserName,Pincode from uld where Status=? and Role_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, roleid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean temp = new UserBean();
				temp.setId(rs.getInt("Id"));
				temp.setName(rs.getString("Name"));
				temp.setUsername(rs.getString("UserName"));
				temp.setPincode(rs.getString("Pincode"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;

	}

	public int set_engineer_task(String token, int id) {
		// TODO Auto-generated method stub
		int temp=0;
		int a=2;
		try {
			Connection con = DBUtil.getconnection();
			String sql="update Complaints_table set Engineer_id=?, Comp_status=?  where Token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, a);
			ps.setString(3, token);
			temp=ps.executeUpdate();
//			if(temp1 > 0) {
//				String sql2="update Complaints_table set Comp_status=? where Token=?";
//				PreparedStatement ps2 = con.prepareStatement(sql2);
//				ps2.setInt(1, status);
//				ps2.setString(2, token);
//				temp2=ps2.executeUpdate();
//				ps2.close();
//			}
			ps.close();
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int pendingcomplaintcount(int u_id) {
		// TODO Auto-generated method stub
		int temp=0;
		int a=1;
		try {
			
			Connection con=DBUtil.getconnection();
			String sql="select count(Comp_status) as pendingcount from Complaints_table where Comp_status=? and u_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setInt(2, u_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				temp=rs.getInt("pendingcount");
			}
			System.out.println(temp);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int successcomplaintcount(int u_id) {
		// TODO Auto-generated method stub
		int temp=0;
		int a=3;
		try {
			
			Connection con=DBUtil.getconnection();
			String sql="select count(Comp_status) as successcount from Complaints_table where Comp_status=? and u_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setInt(2, u_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				temp=rs.getInt("successcount");
			}
			System.out.println(temp);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int processcomplaintcount(int u_id) {
		// TODO Auto-generated method stub
		int temp=0;
		int a=2;
		try {
			
			Connection con=DBUtil.getconnection();
			String sql="select count(Comp_status) as processcount from Complaints_table where Comp_status=? and u_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setInt(2, u_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				temp=rs.getInt("processcount");
			}
			System.out.println(temp);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int rejectcomplaintcount(int u_id) {
		// TODO Auto-generated method stub
		int temp=0;
		int a=4;
		try {
			
			Connection con=DBUtil.getconnection();
			String sql="select count(Comp_status) as rejectcount from Complaints_table where Comp_status=? and u_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setInt(2, u_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				temp=rs.getInt("rejectcount");
			}
			System.out.println(temp);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}
	

}
