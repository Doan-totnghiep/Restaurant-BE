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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amthuc.amthuc.dao.ProductDao;

import com.amthuc.amthuc.entity.ProductEntity;
import com.amthuc.amthuc.entity.ProductRequest;

import com.amthuc.amthuc.service.ProductService;
import com.amthuc.amthuc.serviceImpl.UploadSerVice;



@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	@Autowired
    private ProductService productService;

    @Autowired
    private ProductDao productDao;
 

    private static String upload = "C:\\Users\\Admin\\Desktop\\lvqkhanh_Manager\\src\\assets\\image\\";

    @GetMapping("product")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.ACCEPTED);
    }

    @GetMapping("services")
    public ResponseEntity<?> getAllallService(){
    	return new ResponseEntity<>(productService.getallServices(), HttpStatus.ACCEPTED);
    }
    @GetMapping("product/services")
    public ResponseEntity<?> getallServices(@RequestParam Integer service_id){
    	return new ResponseEntity<>(productService.getallServices(service_id), HttpStatus.ACCEPTED);
    }
  
    @PostMapping("product-search")
    public ResponseEntity<?> searchProduct(@RequestBody String request){
        return new ResponseEntity<>(this.productService.searchProduct(request),HttpStatus.CREATED) ;
    }
   
    @PostMapping("product")
    public ResponseEntity<?> AddProduct(@RequestBody ProductRequest productEntity){
        return new ResponseEntity<>(this.productService.AddProduct(productEntity),HttpStatus.CREATED) ;
    }

    @PostMapping("product/upload/{id}")
    public ResponseEntity<?> UploadFile(@RequestParam MultipartFile file,@PathVariable Integer id){
    	ProductEntity entity = productDao.findById(id).get();
        String FileName = UploadSerVice.UploadOneFile(file,upload);
        entity.setAvatar(FileName);
        productDao.save(entity);
        return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
    }
    @GetMapping("product/{id}")
    public ResponseEntity<?>GetProdutById(@PathVariable Integer id){
    	ProductEntity entity= productDao.findById(id).orElseThrow();
        return ResponseEntity.ok(entity);
    }
 
    //update
    @PutMapping("product/{id}")
    public ResponseEntity<?>UpdateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest){
    	
        return new ResponseEntity<>(this.productService.UpdateProduct(productRequest, id),HttpStatus.ACCEPTED);
    }
    //delete
    @DeleteMapping("product/{id}")
    public Boolean DeleteProduct(@PathVariable Integer id){
        productService.DeleteProduct(id);
        return true;
    }

    
   

    
}

