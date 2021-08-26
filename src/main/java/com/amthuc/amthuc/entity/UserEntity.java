package com.amthuc.amthuc.entity;

import javax.persistence.*;

@Entity
@Table(name = "user2")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user_name;
    private String password;
    private String avatar;
    private String name;
    private String emailId;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role_id;
    
    public Roles getRole_id() {
		return role_id;
	}

	public void setRole_id(Roles role_id) {
		this.role_id = role_id;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }




    
}
