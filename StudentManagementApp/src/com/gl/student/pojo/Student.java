package com.gl.student.pojo;

public class Student {

	private int rollno;
	private String name;
	private String address;
	private String mobileNo;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int rollno, String name, String address, String mobileNo) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}	
}
