package com.amthuc.amthuc.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amthuc.amthuc.dao.ProductDao;
import com.amthuc.amthuc.dao.ServicesDao;
import com.amthuc.amthuc.entity.ProductEntity;
import com.amthuc.amthuc.entity.ProductRequest;
import com.amthuc.amthuc.entity.Services;

import com.amthuc.amthuc.service.ProductService;
@Service
public class ProductServicelmpl implements ProductService {
	 @Autowired
	    private ProductDao productDao;
	 @Autowired
	    private ServicesDao servicesDao;
	 
	@Override
	
	public List<ProductEntity> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	
	
	
	
	@Override
	public ProductEntity AddProduct(ProductRequest Request) {
		ProductEntity newEntity = new ProductEntity();
		Services service = new Services();
		newEntity.setFood_name(Request.getFood_name());
    	newEntity.setPrice(Request.getPrice());
    	newEntity.setContent(Request.getContent());
    	newEntity.setUnit(Request.getUnit());
    	
    	Optional<Services> optionalService = servicesDao.findById(Request.getService_id());
    	service = optionalService.get();
    	newEntity.setService_id(service);
        return productDao.save(newEntity);
	}
	
	
	  

	@Override
	public ProductEntity GetProductById(ProductRequest entityRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductEntity UpdateProduct(ProductRequest Request, Integer id) {
		ProductEntity productEntity1 =productDao.findById(id).orElseThrow();
    	productEntity1.setContent(Request.getContent());
    	productEntity1.setFood_name(Request.getFood_name());
    	productEntity1.setAvatar(Request.getAvatar());
    	productEntity1.setPrice(Request.getPrice());
    	productEntity1.setUnit(Request.getUnit());
    	productEntity1.setService_id(servicesDao.findById(Request.getService_id()).orElseThrow());
		return productDao.save(productEntity1);
	}
	@Override
	public void DeleteProduct(Integer id) {
		// TODO Auto-generated method stub
        productDao.deleteById(id);

	}





	@Override
	public List<ProductEntity> getallServices(Integer service_id) {
	
		List<ProductEntity> ListProductByService = productDao.ListProductByService(service_id);
		return ListProductByService;
	}

	@Override
	public List<Services> getallServices() {
		// TODO Auto-generated method stub
		return servicesDao.findAll();
	}





	@Override
	public List<ProductEntity> searchProduct(String request) {
		return productDao.searchProduct(request);
	}

}
