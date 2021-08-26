package com.amthuc.amthuc.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEnity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private  Integer id;
	    private String content;
	    private String avatar;
	    private Date date;
	    private String title;
	    private String note;
	    private String contentlong;
	    
	    
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public String getContentlong() {
			return contentlong;
		}
		public void setContentlong(String contentlong) {
			this.contentlong = contentlong;
		}
	    
	    
}
