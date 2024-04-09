package com.otz.bean;

public class TempBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String username;
	private String mobile;
	private String password;
	private int Role_id;
	private String Address;
	private String Pincode;
	private String RoleName;
	private String RoleStatus;
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
	public int getRole_id() {
		return Role_id;
	}
	public void setRole_id(int role_id) {
		Role_id = role_id;
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
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getRoleStatus() {
		return RoleStatus;
	}
	public void setRoleStatus(String roleStatus) {
		RoleStatus = roleStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
