package com.amthuc.amthuc.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amthuc.amthuc.dao.CommentDao;
import com.amthuc.amthuc.dao.ProductDao;
import com.amthuc.amthuc.dao.UserDao;
import com.amthuc.amthuc.entity.CommentEntity;
import com.amthuc.amthuc.entity.CommentRequest;
import com.amthuc.amthuc.service.CommentService;

@Service
public class CommentServicelmpl implements CommentService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	UserDao userdao;
	@Autowired
	CommentDao commentDao;
	@Override
	
	
	public List<CommentEntity> GetComment() {
		return commentDao.findAllComment();
	}
	
	@Override
	public CommentEntity CreateComment(CommentRequest commentRequest) {
		// TODO Auto-generated method stub
		CommentEntity entity= new CommentEntity();
		Date date = new java.util.Date();
		entity.setComment(commentRequest.getComment());
		entity.setDatecomment(date);
		entity.setIs_Delete(false);
		entity.setUser_id(userdao.findByEmailId(commentRequest.getEmail()));
		entity.setProduct_id(productDao.findById(commentRequest.getProduct_id()).orElseThrow());
		return commentDao.save(entity);
	}
	@Override
	public CommentEntity GetCommentById(CommentEntity commentEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CommentEntity UpdateComment(CommentRequest commentRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CommentEntity DeleteComment(Integer id) {
		CommentEntity commentService =commentDao.findById(id).orElseThrow();
		commentService.setIs_Delete(true);
		return commentDao.save(commentService);
	}

	@Override
	public List<CommentEntity> GetCommentByProduct(Integer product_id) {
		
		return commentDao.ListCommentByProduct(product_id);
	}
	
	

}
