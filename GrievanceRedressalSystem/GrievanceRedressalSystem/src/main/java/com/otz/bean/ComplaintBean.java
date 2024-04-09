package com.otz.bean;

public class ComplaintBean {
	private int C_Id;
	private int Cat_Id;
	private String cat_name;
	private String C_Name;
	private String mobile;
	private int C_Status;
	private int Status;
	private int u_id;
	private int Comp_id;
	private String Token;
	private String Comp_date;
	private String Comp_Address;
	private String Comp_Pincode;
	private String Comp_desc;
	private String screenshot;
	private int Comp_status;
	private String Complaint_Status_Name;
	private String feedback;
	private int Engineer_id;
	private String Remarks;
	
	
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	public int getCat_Id() {
		return Cat_Id;
	}
	public void setCat_Id(int cat_Id) {
		Cat_Id = cat_Id;
	}
	public int getC_Id() {
		return C_Id;
	}
	public void setC_Id(int c_Id) {
		C_Id = c_Id;
	}
	public String getC_Name() {
		return C_Name;
	}
	public void setC_Name(String c_Name) {
		C_Name = c_Name;
	}
	public int getC_Status() {
		return C_Status;
	}
	public void setC_Status(int c_Status) {
		C_Status = c_Status;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getComp_id() {
		return Comp_id;
	}
	public void setComp_id(int comp_id) {
		Comp_id = comp_id;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public String getComp_date() {
		return Comp_date;
	}
	public void setComp_date(String comp_date) {
		Comp_date = comp_date;
	}
	
	public String getComp_Address() {
		return Comp_Address;
	}
	public void setComp_Address(String comp_Address) {
		Comp_Address = comp_Address;
	}
	public String getComp_Pincode() {
		return Comp_Pincode;
	}
	public void setComp_Pincode(String comp_Pincode) {
		Comp_Pincode = comp_Pincode;
	}
	public String getComp_desc() {
		return Comp_desc;
	}
	public void setComp_desc(String comp_desc) {
		Comp_desc = comp_desc;
	}
	public String getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}
	public int getComp_status() {
		return Comp_status;
	}
	public void setComp_status(int comp_status) {
		Comp_status = comp_status;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getComplaint_Status_Name() {
		return Complaint_Status_Name;
	}
	public void setComplaint_Status_Name(String complaint_Status_Name) {
		Complaint_Status_Name = complaint_Status_Name;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getEngineer_id() {
		return Engineer_id;
	}
	public void setEngineer_id(int engineer_id) {
		Engineer_id = engineer_id;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

}
