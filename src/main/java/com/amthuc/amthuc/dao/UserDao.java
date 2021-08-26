package com.amthuc.amthuc.dao;

import com.amthuc.amthuc.entity.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Integer> {
    UserEntity findByEmailId(String email_id);
    UserEntity findByEmailIdAndPassword(String email_id,String password);
    
    @Query(value="select * from user2 u where u.user_name like %:searchValue% or u.name like %:searchValue% or u.email_id like %:searchValue%", nativeQuery = true)
    List<UserEntity> searchUser(@Param("searchValue") String request);
}

