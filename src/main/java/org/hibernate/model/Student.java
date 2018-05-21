package org.hibernate.model;

import java.sql.Blob;
import java.util.Date;

public class Student {
	private long sid;// 学号
	private String sname;// 姓名
	private String gender;// 性别
	private Date birthday;// 生日
	private String address;// 性别
	private Blob image;// 头像
	
	public Student() {
	
	}

	public Student(String sname, String gender, Date birthday, String address, Blob image) {
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.image = image;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	
	
}
