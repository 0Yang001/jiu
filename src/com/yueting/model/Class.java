package com.yueting.model;

import java.util.Date;

public class Class {
	private int id ;
	private String classname;
	private String classadreass ;
	private Date starttime;
	private Date eddtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getClassadreass() {
		return classadreass;
	}
	public void setClassadreass(String classadreass) {
		this.classadreass = classadreass;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEddtime() {
		return eddtime;
	}
	public void setEddtime(Date eddtime) {
		this.eddtime = eddtime;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", classname=" + classname + ", classadreass=" + classadreass + ", starttime="
				+ starttime + ", eddtime=" + eddtime + "]";
	}
	
	
	
}
