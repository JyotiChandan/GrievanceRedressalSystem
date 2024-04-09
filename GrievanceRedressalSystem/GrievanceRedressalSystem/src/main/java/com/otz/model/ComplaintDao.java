package com.otz.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.otz.bean.ComplaintBean;

public class ComplaintDao {

	public List<ComplaintBean> getComplaintsName() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> complaintlist = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaint_type";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setC_Id(rs.getInt("C_id"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setC_Status(rs.getInt("C_Status"));
				complaintlist.add(temp);
			}
			con.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return complaintlist;
	}

	public int set_complaint(ComplaintBean set_Complaint) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "insert into Complaint_Type(C_Name,C_Status) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, set_Complaint.getC_Name());
			ps.setInt(2, set_Complaint.getC_Status());
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int deleteComplaintType(int id) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "DELETE FROM Complaint_type WHERE C_Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<ComplaintBean> fetchComplaint(int id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> complaintdetais = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaint_type where C_Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setC_Id(rs.getInt("C_Id"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setC_Status(rs.getInt("C_Status"));
				complaintdetais.add(temp);
			}
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return complaintdetais;
	}

	public int update_complaint(ComplaintBean complaint) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update complaint_type set C_name=?,C_Status=? where C_Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, complaint.getC_Name());
			ps.setInt(2, complaint.getC_Status());
			ps.setInt(3, complaint.getC_Id());
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int setNewCatagory(ComplaintBean catagory) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "insert into Complaint_Catagory_lists(C_Id,Cat_name,Status) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, catagory.getC_Id());
			ps.setString(2, catagory.getC_Name());
			ps.setInt(3, catagory.getC_Status());
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<ComplaintBean> fetchAllComplaintData(int id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> complaintdetais = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaint_Catagory_lists where C_Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setC_Id(rs.getInt("C_Id"));
				temp.setCat_Id(rs.getInt("Cat_Id"));
				temp.setC_Name(rs.getString("cat_name"));
				temp.setC_Status(rs.getInt("Status"));
//				System.out.println(temp.getC_Id());
//				System.out.println(temp.getCat_Id());
//				System.out.println(temp.getC_Name());
//				System.out.println(temp.getC_Status());
				complaintdetais.add(temp);
			}
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return complaintdetais;
	}

	public int change_Status_To_Zero(int id) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update Complaint_Catagory_lists set Status=? where Cat_Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, id);
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public int change_Status_To_One(int id) {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update Complaint_Catagory_lists set Status=? where Cat_Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, id);
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<ComplaintBean> get_Complaint_Type() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaint_Type";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setC_Id(rs.getInt("C_Id"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setC_Status(rs.getInt("C_Status"));
				lists.add(temp);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_Complaint_catagory_Type_list(int id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaint_Catagory_lists where C_Id=? and Complaint_Catagory_lists.Status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, 1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setC_Id(rs.getInt("C_Id"));
				temp.setCat_Id(rs.getInt("Cat_Id"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setC_Status(rs.getInt("Status"));
				lists.add(temp);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public int set_complaint2(ComplaintBean temp) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "insert into Complaints_table (u_id,mobile,C_id,Cat_id,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot) values(?,?,?,?,?,now(),?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, temp.getU_id());
			ps.setString(2, temp.getMobile());
			ps.setInt(3, temp.getC_Id());
			ps.setInt(4, temp.getCat_Id());
			ps.setString(5, temp.getToken());
//			ps.setString(5, new Timestamp(System.currentTimeMillis()));
			ps.setString(6, temp.getComp_Address());
			ps.setString(7, temp.getComp_Pincode());
			ps.setString(8, temp.getComp_desc());
			ps.setString(9, temp.getScreenshot());
			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public List<ComplaintBean> get_all_complaints(int u_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.u_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u_id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;

	}

	public List<ComplaintBean> get_all_resolved_complaints(int u_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select u_id,Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.u_id=? and Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setInt(2, 3);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_all_Pending_complaints(int u_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.u_id=? and Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setInt(2, 1);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_all_Rejected_complaints(int u_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.u_id=? and Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setInt(2, 4);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_All_Process_Complains(int u_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.u_id=? and Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setInt(2, 2);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public int token_verification(String token) {
		// TODO Auto-generated method stub
		int rowcount = 0;
		try {
			System.out.print(token);
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaints_table where token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, token);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rowcount = 1;
			}

			System.out.println(rowcount);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rowcount;
	}

	public int set_feedback(ComplaintBean temp) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "insert into feedback (Customer_id,Date,token,Description) values(?,now(),?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, temp.getU_id());
			ps.setString(2, temp.getToken());
			ps.setString(3, temp.getFeedback());
			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(status);
		return status;

	}

	public List<ComplaintBean> get_all_feedback() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			Connection con = DBUtil.getconnection();
			String sql = "SELECT * FROM GRS.feedback";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("customer_id"));
//			String date = dateObj.toString();
				Date dateObj = rs.getDate("Date");
				temp.setComp_date(dateObj.toString());
				temp.setToken(rs.getString("Token"));
				temp.setComp_desc(rs.getString("Description"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_all_Pending_complaints_admin() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			int status = 1;
			Connection con = DBUtil.getconnection();
			String sql = "select u_id,Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
//				temp.setComp_date(dateFormat.format(rs.getDate("Comp_date")));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_All_Process_Complains_admin() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			int status = 2;
			Connection con = DBUtil.getconnection();
			String sql = "select u_id,Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
//				temp.setComp_date(dateFormat.format(rs.getDate("Comp_date")));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_all_Rejected_complaints_admin() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			int status = 4;
			Connection con = DBUtil.getconnection();
			String sql = "select u_id,Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
//				temp.setComp_date(dateFormat.format(rs.getDate("Comp_date")));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_all_resolved_complaints_admin() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			int status = 3;
			Connection con = DBUtil.getconnection();
			String sql = "select u_id,Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, status);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
//				temp.setComp_date(dateFormat.format(rs.getDate("Comp_date")));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_All_Revert_Complains_admin() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			int status = 5;
			Connection con = DBUtil.getconnection();
			String sql = "select u_id,Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id where Complaints_table.Comp_status=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, status);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
//				temp.setComp_date(dateFormat.format(rs.getDate("Comp_date")));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_all_complaints_admin() {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			Connection con = DBUtil.getconnection();
//			String sql = "select Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id";
			String sql = "select u_id,Comp_id,mobile,C_Name,cat_name,Token,Comp_date,Comp_Address,Com_Pincode,Comp_desc,screenshot,Complaint_Status_Name from Complaints_table INNER JOIN Complaint_type On Complaints_table.c_id = Complaint_Type.c_Id INNER JOIN Complaint_Catagory_lists on Complaints_table.Cat_Id=Complaint_Catagory_lists.cat_id INNER JOIN Complaint_Status on Complaints_table.Comp_status = Complaint_Status.Complaint_id";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
//				temp.setComp_date(dateFormat.format(rs.getDate("Comp_date")));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;

	}

	public List<ComplaintBean> get_all_engineer_task(int e_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			int num = 0;
			int n = 0;
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaints_table inner join Complaint_Type on Complaints_table.C_id = Complaint_Type.C_Id inner join Complaint_Catagory_lists on Complaints_table.Cat_id = Complaint_Catagory_lists.Cat_Id where Engineer_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				num = rs.getInt("Complaints_table.Comp_status");
				n = rs.getInt("Complaints_table.Engineer_visit_status");
				System.out.println(num);
				System.out.println(n);
				if ((num == 2) && (n == 0)) {
					num = num - 1;
					String sql2 = "select * from Complaint_Status where Complaint_id=?";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, num);
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						temp.setComplaint_Status_Name(rs2.getString("Complaint_Status_Name"));
					}

				} else if ((num >= 2) && (n == 1)) {
					String sql2 = "select * from Complaint_Status where Complaint_id=?";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, num);
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						temp.setComplaint_Status_Name(rs2.getString("Complaint_Status_Name"));
					}
				}
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;

	}

//	public List<ComplaintBean> get_all_resolved_engineer_task(int e_id) {
//		// TODO Auto-generated method stub
//		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		try {
//			int num=3;
//			Connection con = DBUtil.getconnection();
//			String sql = "select * from \n"
//					+ "GRS.Complaints_table INNER JOIN GRS.Complaint_Type On GRS.Complaints_table.C_id = GRS.Complaint_Type.C_id\n"
//					+ "RIGHT JOIN GRS.Complaint_Status on GRS.Complaints_table.Comp_status = GRS.Complaint_Status.Complaint_id\n"
//					+ "RIGHT JOIN GRS.Complaint_Progress on GRS.Complaints_table.Token = GRS.Complaint_Progress.Token \n"
//					+ "RIGHT JOIN GRS.Complaint_Catagory_lists on GRS.Complaint_Catagory_lists.Cat_id = GRS.Complaints_table.Cat_id\n"
//					+ "Where GRS.Complaint_Progress.Token=GRS.Complaints_table.Token and GRS.Complaint_Progress.Engineer_id=? and GRS.Complaint_Progress.Complaint_status=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, e_id);
//			ps.setInt(2, num);
//			ResultSet rs = ps.executeQuery();
//			ComplaintBean temp = new ComplaintBean();
//			temp.setComp_id(rs.getInt("Comp_id"));
//			temp.setMobile(rs.getString("mobile"));
//			temp.setC_Name(rs.getString("C_Name"));
//			temp.setCat_name(rs.getString("cat_name"));
//			temp.setToken(rs.getString("token"));
//			temp.setComp_date(dateFormat.format(rs.getDate("Comp_date")));
//			temp.setComp_Address(rs.getString("Comp_Address"));
//			temp.setComp_Pincode(rs.getString("Com_Pincode"));
//			temp.setComp_desc(rs.getString("Comp_desc"));
//			temp.setScreenshot(rs.getString("screenshot"));
//			temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
//			lists.add(temp);
//		}catch (Exception ex) {
//		ex.printStackTrace();
//	}
//	return lists;
//			
//	}

	public List<ComplaintBean> get_all_pending_engineer_task(int e_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		try {
			int num = 0;
			int num2 = 0;
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaints_table inner join Complaint_Type on Complaints_table.C_id = Complaint_Type.C_Id inner join Complaint_Catagory_lists on Complaints_table.Cat_id = Complaint_Catagory_lists.Cat_Id where Engineer_id=? and Engineer_visit_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e_id);
			ps.setInt(2, num2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				num = rs.getInt("Complaints_table.Comp_status");
				if (num == 2) {
					num = num - 1;
					String sql2 = "select * from Complaint_Status where Complaint_id=?";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, num);
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						temp.setComplaint_Status_Name(rs2.getString("Complaint_Status_Name"));
					}

				}
//				else {
//				temp.setComplaint_Status_Name(rs.getString("Complaint_Status.Complaint_Status_Name"));
//				}
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;

	}

	public int makeComplaintProcess(String pincode) {
		// TODO Auto-generated method stub
		int temp = 0;
		int a = 1;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update Complaints_table set Engineer_visit_status=? where token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setString(2, pincode);
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<ComplaintBean> get_all_process_engineer_task(int e_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		int num1 = 2;
		int num2 = 1;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaints_table inner join Complaint_Type on Complaints_table.C_id = Complaint_Type.C_Id inner join Complaint_Catagory_lists on Complaints_table.Cat_id = Complaint_Catagory_lists.Cat_Id inner join Complaint_Status on GRS.Complaints_table.Comp_status = GRS.Complaint_Status.Complaint_id where Engineer_id=? and Comp_status=? and Engineer_visit_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e_id);
			ps.setInt(2, num1);
			ps.setInt(3, num2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("1");
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));

				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public int makeComplaintSolved(String pincode) {
		// TODO Auto-generated method stub
		int temp = 0;
		int a = 3;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update Complaints_table set Comp_status=? where token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setString(2, pincode);
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<ComplaintBean> get_all_Resolved_engineer_task(int e_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		int num1 = 3;
		int num2 = 1;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaints_table inner join Complaint_Type on Complaints_table.C_id = Complaint_Type.C_Id inner join Complaint_Catagory_lists on Complaints_table.Cat_id = Complaint_Catagory_lists.Cat_Id inner join Complaint_Status on GRS.Complaints_table.Comp_status = GRS.Complaint_Status.Complaint_id where Engineer_id=? and Comp_status=? and Engineer_visit_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e_id);
			ps.setInt(2, num1);
			ps.setInt(3, num2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("1");
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));

				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public int makeComplaintReject(String token, String remark) {
		// TODO Auto-generated method stub
		int temp = 0;
		int a = 4;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update Complaints_table set Comp_status=?,Remarks=? where token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setString(2, remark);
			ps.setString(3, token);
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	public List<ComplaintBean> get_all_Rejected_engineer_task(int e_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		int num1 = 4;
		int num2 = 1;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaints_table inner join Complaint_Type on Complaints_table.C_id = Complaint_Type.C_Id inner join Complaint_Catagory_lists on Complaints_table.Cat_id = Complaint_Catagory_lists.Cat_Id inner join Complaint_Status on GRS.Complaints_table.Comp_status = GRS.Complaint_Status.Complaint_id where Engineer_id=? and Comp_status=? and Engineer_visit_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e_id);
			ps.setInt(2, num1);
			ps.setInt(3, num2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				temp.setRemarks(rs.getString("Remarks"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;
	}

	public List<ComplaintBean> get_all_Revert_engineer_task(int e_id) {
		// TODO Auto-generated method stub
		ArrayList<ComplaintBean> lists = new ArrayList<ComplaintBean>();
		int num1 = 5;
		int num2 = 1;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "select * from Complaints_table inner join Complaint_Type on Complaints_table.C_id = Complaint_Type.C_Id inner join Complaint_Catagory_lists on Complaints_table.Cat_id = Complaint_Catagory_lists.Cat_Id inner join Complaint_Status on GRS.Complaints_table.Comp_status = GRS.Complaint_Status.Complaint_id where Engineer_id=? and Comp_status=? and Engineer_visit_status=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e_id);
			ps.setInt(2, num1);
			ps.setInt(3, num2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComplaintBean temp = new ComplaintBean();
				temp.setU_id(rs.getInt("u_id"));
				temp.setComp_id(rs.getInt("Comp_id"));
				temp.setMobile(rs.getString("mobile"));
				temp.setC_Name(rs.getString("C_Name"));
				temp.setCat_name(rs.getString("cat_name"));
				temp.setToken(rs.getString("token"));
				Date dateObj = rs.getDate("Comp_date");
				temp.setComp_date(dateObj.toString());
				temp.setComp_Address(rs.getString("Comp_Address"));
				temp.setComp_Pincode(rs.getString("Com_Pincode"));
				temp.setComp_desc(rs.getString("Comp_desc"));
				temp.setScreenshot(rs.getString("screenshot"));
				temp.setComplaint_Status_Name(rs.getString("Complaint_Status_Name"));
				temp.setRemarks(rs.getString("Remarks"));
				lists.add(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lists;

	}

	public int makeComplaintRevert(String token, String remark) {
		// TODO Auto-generated method stub
		int temp = 0;
		int a = 5;
		try {
			Connection con = DBUtil.getconnection();
			String sql = "update Complaints_table set Comp_status=?,Remarks=? where token=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setString(2, remark);
			ps.setString(3, token);
			temp = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return temp;
	}

}
