package com.amthuc.amthuc.controller;



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

import org.springframework.web.bind.annotation.RestController;


import com.amthuc.amthuc.dao.OrderDao;
import com.amthuc.amthuc.entity.OrderEntity;
import com.amthuc.amthuc.service.OrderService;


@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class OrderController {
	@Autowired
    private OrderService orderService;

    @Autowired
    private OrderDao orderDao;

   

    @GetMapping("order")
    public ResponseEntity<?> getAddOrder(){
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.ACCEPTED);
    }

    @PostMapping("order-search")
    public ResponseEntity<?> searchOrder(@RequestBody String request){
        return new ResponseEntity<>(this.orderService.searchOrder(request),HttpStatus.CREATED) ;
    }
    
    @PostMapping("order")
    public ResponseEntity<?> AddOrder(@RequestBody OrderEntity orderEntity){
        return new ResponseEntity<>(this.orderService.AddOrder(orderEntity),HttpStatus.CREATED) ;
    }

   
    @GetMapping("order/{id}")
    public ResponseEntity<?>GetBlogById(@PathVariable Integer id){
    	OrderEntity entity= orderDao.findById(id).orElseThrow();
        return ResponseEntity.ok(entity);
    }
 
    //update
    @PutMapping("order/{id}")
    public ResponseEntity<?>UpdateOrder(@PathVariable Integer id, @RequestBody OrderEntity orderEntity){
    	OrderEntity orderEntity1 =orderDao.findById(id).orElseThrow();
    	orderEntity1.setDate(orderEntity.getDate());
    	orderEntity1.setHour(orderEntity.getHour());
    	orderEntity1.setTh(orderEntity.getTh());
    	orderEntity1.setFullname(orderEntity.getFullname());
    	orderEntity1.setPhonenumber(orderEntity.getPhonenumber());
    	orderEntity1.setPerson(orderEntity.getPerson());
        return new ResponseEntity<>(this.orderService.UpdateOrder(orderEntity1),HttpStatus.ACCEPTED);
        
 
	 
    }
    //delete
    @DeleteMapping("order/{id}")
    public Boolean DeleteOrder(@PathVariable Integer id){
        orderService.DeleteOrder(id);
        return true;
    }

}
