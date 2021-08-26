package com.amthuc.amthuc.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amthuc.amthuc.dao.BlogDao;

import com.amthuc.amthuc.entity.BlogEnity;

import com.amthuc.amthuc.service.BlogService;
@Service
public class BlogServicelmpl implements BlogService {
	@Autowired
    private BlogDao blogDao;

	@Override
	public List<BlogEnity> getAllBlog() {
		// TODO Auto-generated method stub
		return blogDao.findAll();
	}

	@Override
	public BlogEnity AddBlog(BlogEnity entityRequest) {
		BlogEnity newEntity = new BlogEnity();
		Date date=new java.util.Date();
		newEntity.setDate(date);
		newEntity.setTitle(entityRequest.getTitle());
    	newEntity.setContent(entityRequest.getContent());
    	newEntity.setNote(entityRequest.getNote());
    	newEntity.setContentlong(entityRequest.getContentlong());
        return blogDao.save(newEntity);
	}

	@Override
	public BlogEnity GetBlogById(BlogEnity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEnity UpdateBlog(BlogEnity entity) {
		// TODO Auto-generated method stub
		
        return blogDao.save(entity);
	}

	@Override
	public void DeleteBlog(Integer id) {
		// TODO Auto-generated method stub
		blogDao.deleteById(id);
	}

	@Override
	public List<BlogEnity> searchBlog(String request) {
		return blogDao.searchBlog(request);
		
	}

	

}
