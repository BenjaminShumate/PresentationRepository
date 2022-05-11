package com.web.store.music_store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int user_id;
	private String username;
	private String password;
	private String privilege;
	private String billing;
	private String cardNum;
	
	public User() {
		super();
	}
	
	public User(int user_id, String username, String password, String privilege, String billing, String cardNum) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.privilege = privilege;
		this.billing = billing;
		this.cardNum = cardNum;
	}
	
	public String getBilling() {
		return billing;
	}
	public void setBilling(String billing) {
		this.billing = billing;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}
