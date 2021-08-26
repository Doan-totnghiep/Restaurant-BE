package com.amthuc.amthuc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amthuc.amthuc.entity.BlogEnity;





@Repository
public interface BlogDao extends JpaRepository<BlogEnity,Integer> {
	 @Query(value="select * from blog u where u.title like %:searchValue% or u.content like %:searchValue% or u.contentlong like %:searchValue% or u.date like %:searchValue% or u.note like %:searchValue%", nativeQuery = true)
	    List<BlogEnity> searchBlog(@Param("searchValue") String request);
}
