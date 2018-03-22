package com.yueting.model;

public class Users {
	 
	private int id ;
	private String account;
	private String username ;
	private String email;
	private String psw;
	private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", account=" + account + ", username=" + username + ", email=" + email + ", psw="
				+ psw + ", role=" + role + "]";
	}
	
	
	
	
}
