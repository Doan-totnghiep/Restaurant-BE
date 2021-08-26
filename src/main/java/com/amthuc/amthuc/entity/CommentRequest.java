package com.amthuc.amthuc.entity;

import java.util.Date;

public class CommentRequest {
	private Integer id ;
    private String comment ;
    private Date datecomment;
    private String email;
    private Integer user_id;
    private Integer product_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDatecomment() {
		return datecomment;
	}
	public void setDatecomment(Date datecomment) {
		this.datecomment = datecomment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
    
    
}
