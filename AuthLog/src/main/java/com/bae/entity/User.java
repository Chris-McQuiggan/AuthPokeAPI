package com.bae.entity;


public class User {

	private Long id;
	private String memberNumber;
	private String username;
	
	public User() {
		super();
	}
	
	public User(Long id, String memberNumber, String username) {
		super();
		this.id = id;
		this.memberNumber = memberNumber;
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
