package com.amthuc.amthuc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amthuc.amthuc.entity.CommentRequest;
import com.amthuc.amthuc.service.CommentService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class CommentController {
	@Autowired
	private CommentService commentService;
//	@Autowired
//	private CommentDao commentDao;
//	
	@GetMapping("comment")
	public ResponseEntity<?> GetComment(){
		return new ResponseEntity<>(commentService.GetComment(),HttpStatus.ACCEPTED);
	}
	@GetMapping("comment-byproduct")
	public ResponseEntity<?> GetCommentByProduct( @RequestParam Integer product_id){
		return new ResponseEntity<>(commentService.GetCommentByProduct(product_id),HttpStatus.ACCEPTED);
	}
	 @DeleteMapping("comment/{id}")
	    public Boolean DeleteComment(@PathVariable Integer id){
	        commentService.DeleteComment(id);
	        return true;
	    }
	@PostMapping("comment")
	public ResponseEntity<?> CreateComment(@RequestBody CommentRequest commentRequest ){
		return new ResponseEntity<>(commentService.CreateComment(commentRequest),HttpStatus.CREATED);
	}
}
