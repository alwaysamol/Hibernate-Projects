package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Data")
public class User {

	@Id
	@Column(name="userId")
	private int uid;
	
	@Column(name="userName")
	private String uname;
	
	@Column(name="MobileNumber")
	private long mno;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(long mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", mno=" + mno + "]";
	}
}
