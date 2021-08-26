package com.amthuc.amthuc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amthuc.amthuc.entity.OrderEntity;


@Repository
public interface OrderDao extends JpaRepository<OrderEntity,Integer>{
	 @Query(value="select * from orderer u where u.fullname like %:searchValue% or u.date like %:searchValue% or u.th like %:searchValue% or u.hour like %:searchValue% or u.person like %:searchValue%  or u.phonenumber like %:searchValue%", nativeQuery = true)
	    List<OrderEntity> searchOrder(@Param("searchValue") String request);
}
