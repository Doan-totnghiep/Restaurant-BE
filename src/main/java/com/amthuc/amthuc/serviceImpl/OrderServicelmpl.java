package com.amthuc.amthuc.serviceImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.amthuc.amthuc.dao.OrderDao;

import com.amthuc.amthuc.entity.OrderEntity;
import com.amthuc.amthuc.service.OrderService;
@Service
public class OrderServicelmpl implements OrderService{
	@Autowired
    private OrderDao orderDao;
	@Override
	public List<OrderEntity> getAllOrder() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public OrderEntity AddOrder(OrderEntity entityRequest) {
		// TODO Auto-generated method stub
		OrderEntity newEntity = new OrderEntity();
		
		Date date=new java.util.Date();
		newEntity.setDate(date);
    	newEntity.setHour(entityRequest.getHour());
    	newEntity.setFullname(entityRequest.getFullname());
    	newEntity.setPhonenumber(entityRequest.getPhonenumber());
    	newEntity.setPerson(entityRequest.getPerson());
    	newEntity.setTh(entityRequest.getTh());
        return orderDao.save(newEntity);
    
	}

	@Override
	public OrderEntity GetOrderById(OrderEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity UpdateOrder(OrderEntity entity) {
		// TODO Auto-generated method stub
		return orderDao.save(entity);
	}

	@Override
	public void DeleteOrder(Integer id) {
		// TODO Auto-generated method stub
		orderDao.deleteById(id);
		
	}

	@Override
	public List<OrderEntity> searchOrder(String request) {
		// TODO Auto-generated method stub
		return orderDao.searchOrder(request);
	}

}
