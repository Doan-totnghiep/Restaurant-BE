package com.amthuc.amthuc.dao;

import com.amthuc.amthuc.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<CartEntity,Integer> {
}
