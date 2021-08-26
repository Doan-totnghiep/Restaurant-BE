package com.amthuc.amthuc.service;

import java.util.List;

import com.amthuc.amthuc.entity.ProductEntity;
import com.amthuc.amthuc.entity.ProductRequest;

import com.amthuc.amthuc.entity.Services;



public interface ProductService {
	 List<ProductEntity> getAllProduct();
	 List<ProductEntity> getallServices(Integer service_id);
	 List<Services> getallServices();
	 List<ProductEntity> searchProduct(String request);
	 ProductEntity AddProduct(ProductRequest entityRequest);
	 ProductEntity GetProductById (ProductRequest entityRequest);
	 ProductEntity UpdateProduct(ProductRequest entityRequest, Integer id);
	 void DeleteProduct(Integer id);
}
