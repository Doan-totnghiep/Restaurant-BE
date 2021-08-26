package com.amthuc.amthuc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id ;
	    private String comment ;
	    private Date datecomment;
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private UserEntity user_id;
	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private ProductEntity product_id ;
	    private boolean is_Delete;
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
		public UserEntity getUser_id() {
			return user_id;
		}
		public void setUser_id(UserEntity user_id) {
			this.user_id = user_id;
		}
		public ProductEntity getProduct_id() {
			return product_id;
		}
		public void setProduct_id(ProductEntity product_id) {
			this.product_id = product_id;
		}
		public boolean isIs_Delete() {
			return is_Delete;
		}
		public void setIs_Delete(boolean is_Delete) {
			this.is_Delete = is_Delete;
		}
	    
	    
}
