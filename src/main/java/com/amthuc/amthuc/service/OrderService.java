package com.amthuc.amthuc.service;

import java.util.List;

import com.amthuc.amthuc.entity.OrderEntity;



public interface OrderService {
	
		 List<OrderEntity> getAllOrder();
		 List<OrderEntity> searchOrder(String request);
		 OrderEntity AddOrder(OrderEntity entityRequest);
		 OrderEntity GetOrderById (OrderEntity entity);
		 OrderEntity UpdateOrder(OrderEntity entity);
		 void DeleteOrder(Integer id);
}
