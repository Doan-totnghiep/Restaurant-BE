package com.amthuc.amthuc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amthuc.amthuc.dao.BlogDao;
import com.amthuc.amthuc.entity.BlogEnity;
import com.amthuc.amthuc.service.BlogService;
import com.amthuc.amthuc.serviceImpl.UploadSerVice;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class BlogController {
	@Autowired
    private BlogService blogService;

    @Autowired
    private BlogDao blogDao;

    private static String upload = "C:\\Users\\Admin\\Desktop\\lvqkhanh_Manager\\src\\assets\\image\\";

    @GetMapping("blog")
    public ResponseEntity<?> getAddBlog(){
        return new ResponseEntity<>(blogService.getAllBlog(), HttpStatus.ACCEPTED);
    }

   //ngu
    @PostMapping("blog-search")
    public ResponseEntity<?> searchBlog(@RequestBody String request){
        return new ResponseEntity<>(this.blogService.searchBlog(request),HttpStatus.CREATED) ;
    }
    @PostMapping("blog")
    public ResponseEntity<?> AddBlog(@RequestBody BlogEnity blogEntity){
        return new ResponseEntity<>(this.blogService.AddBlog(blogEntity),HttpStatus.CREATED) ;
    }

    @PostMapping("blog/upload/{id}")
    public ResponseEntity<?> UploadFile(@RequestParam MultipartFile file,@PathVariable Integer id){
    	BlogEnity entity = blogDao.findById(id).get();
        String FileName = UploadSerVice.UploadOneFile(file,upload);
        entity.setAvatar(FileName);
        blogDao.save(entity);
        return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
    }
    @GetMapping("blog/{id}")
    public ResponseEntity<?>GetBlogById(@PathVariable Integer id){
    	BlogEnity entity= blogDao.findById(id).orElseThrow();
        return ResponseEntity.ok(entity);
    }
 
    //update
    @PutMapping("blog/{id}")
    public ResponseEntity<?>UpdateBlog(@PathVariable Integer id, @RequestBody BlogEnity blogEntity){
    	BlogEnity blogEntity1 =blogDao.findById(id).orElseThrow();
    	Date date=new java.util.Date();
    	blogEntity1.setDate(date);
    	blogEntity1.setContent(blogEntity.getContent());
    	blogEntity1.setAvatar(blogEntity.getAvatar());
    	blogEntity1.setTitle(blogEntity.getTitle());
    	blogEntity1.setNote(blogEntity.getNote());
    	blogEntity1.setContentlong(blogEntity.getContentlong());
        return new ResponseEntity<>(this.blogService.UpdateBlog(blogEntity1),HttpStatus.ACCEPTED);
    }
    //delete
    @DeleteMapping("blog/{id}")
    public Boolean DeleteBlog(@PathVariable Integer id){
        blogService.DeleteBlog(id);
        return true;
    }

}
