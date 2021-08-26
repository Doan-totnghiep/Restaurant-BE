package com.amthuc.amthuc.dao;

import com.amthuc.amthuc.entity.ProductEntity;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Integer> {
	@Query(value="SELECT * FROM amthuc.product WHERE service_id =?1", nativeQuery = true)
	List<ProductEntity> ListProductByService(int service_id);
	
	 @Query(value="select * from product u where u.food_name like %:searchValue% or u.price like %:searchValue% or u.unit like %:searchValue% or u.content like %:searchValue% or u.service_id like %:searchValue%", nativeQuery = true)
	    List<ProductEntity> searchProduct(@Param("searchValue") String request);
	
}
