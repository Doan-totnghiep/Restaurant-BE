package com.amthuc.amthuc.entity;




public class UserRequest {

    private Integer id ;
	private String user_name ;
    private String emailId ;
    private String name ;
    private String password ;
    private String avatar ;
    private Integer role_id;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    public Integer getId() {
		return id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	
}
