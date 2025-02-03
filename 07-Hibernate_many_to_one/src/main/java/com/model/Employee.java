package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Employee {

	@Id
	private int eid;
	private String ename;
	private long mno;
	
	
	@ManyToOne
	private Department dept;
	
	public Employee() {
		super();
		//ToDo Auto-generated constructor stub
	}
	
		public Employee(int eid, String ename, long mno) {
			this.eid = eid;
			this.ename = ename;
			this.mno = mno;
			
		}
		

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public long getMno() {
		return mno;
	}

	public void setMno(long mno) {
		this.mno = mno;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employe [eid=" + eid + ", ename=" + ename + ", mno=" + mno + ", dept=" + dept + "]";
	}	
}


