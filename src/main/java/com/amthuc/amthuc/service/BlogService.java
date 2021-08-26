package com.amthuc.amthuc.service;

import java.util.List;

import com.amthuc.amthuc.entity.BlogEnity;



public interface BlogService {
	 List<BlogEnity> getAllBlog();
	 List<BlogEnity> searchBlog(String request);
	 BlogEnity AddBlog(BlogEnity entityRequest);
	 BlogEnity GetBlogById (BlogEnity entity);
	 BlogEnity UpdateBlog(BlogEnity entity);
	 void DeleteBlog(Integer id);
}
