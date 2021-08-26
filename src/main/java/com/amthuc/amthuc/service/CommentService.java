package com.amthuc.amthuc.service;

import java.util.List;

import com.amthuc.amthuc.entity.CommentEntity;
import com.amthuc.amthuc.entity.CommentRequest;

public interface CommentService {

	List<CommentEntity>GetComment();
	List<CommentEntity>GetCommentByProduct(Integer product_id);
	CommentEntity CreateComment(CommentRequest commentRequest );
	CommentEntity GetCommentById(CommentEntity commentEntity );
	CommentEntity UpdateComment(CommentRequest commentRequest );
	CommentEntity DeleteComment(Integer id);
	
}
