package com.otz.bean;

public class AdminBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String username;
	private String mobile;
	private String password;
	private String confirm_password;
	private int Role_id;
	private String Address;
	private String Pincode;
	private String img_profile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	public void setRole_id(int role_id) {
		this.Role_id = role_id;
	}
	public int getRole_id() {
		return Role_id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String ppincode) {
		Pincode = ppincode;
	}
	public String getImg_profile() {
		return img_profile;
	}
	public void setImg_profile(String img_profile) {
		this.img_profile = img_profile;
	}
}
