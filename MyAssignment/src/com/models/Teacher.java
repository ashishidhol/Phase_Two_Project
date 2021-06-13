package com.models;

public class Teacher {
	private int id;
	private String name;
	private String gender;
	private String assign_class;
	private String sub_assign;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAssign_class() {
		return assign_class;
	}
	public void setAssign_class(String assign_class) {
		this.assign_class = assign_class;
	}
	public String getSub_assign() {
		return sub_assign;
	}
	public void setSub_assign(String sub_assign) {
		this.sub_assign = sub_assign;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", assign_class=" + assign_class
				+ ", sub_assign=" + sub_assign + "]";
	}
	
}
