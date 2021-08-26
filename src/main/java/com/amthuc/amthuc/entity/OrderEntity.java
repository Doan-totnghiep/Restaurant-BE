package com.amthuc.amthuc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderer")
public class OrderEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private  Integer id;
	    private Date date;
	    private String hour;
	    private String fullname;
	    private String phonenumber;
	    private String person;
	    private String th;
	    
		public Integer getId() {
			return id;
		} 
		public void setId(Integer id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getHour() {
			return hour;
		}
		public void setHour(String hour) {
			this.hour = hour;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getPerson() {
			return person;
		}
		public void setPerson(String person) {
			this.person = person;
		}
		public String getTh() {
			return th;
		}
		public void setTh(String th) {
			this.th = th;
		}
	    
	    
}
