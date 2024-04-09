package com.otz.bean;

public class RoleBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int Id;
	private String Name;
	private int Status;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status2) {
		Status = status2;
	}
}
