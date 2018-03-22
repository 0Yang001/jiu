package com.yueting.model;

import java.util.Date;

public class Company {
	private int id ;
	private String comname;
	private String jianjie;
	private String xuqiu;
	private String address;
	private Date jitime;
	private Date endtime;
	private String zhuangtai ;
	
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public String getXuqiu() {
		return xuqiu;
	}
	public void setXuqiu(String xuqiu) {
		this.xuqiu = xuqiu;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJitime() {
		return jitime;
	}
	public void setJitime(Date jitime) {
		this.jitime = jitime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", comname=" + comname + ", jianjie=" + jianjie + ", xuqiu=" + xuqiu + ", address="
				+ address + ", jitime=" + jitime + ", endtime=" + endtime + ", zhuangtai=" + zhuangtai + "]";
	}
	
	 
	
}
