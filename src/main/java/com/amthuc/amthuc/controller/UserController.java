package com.amthuc.amthuc.controller;

import com.amthuc.amthuc.dao.UserDao;

import com.amthuc.amthuc.entity.UserEntity;
import com.amthuc.amthuc.entity.UserRequest;
import com.amthuc.amthuc.service.UserService;
import com.amthuc.amthuc.serviceImpl.UploadSerVice;
//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    private static String upload = "C:\\Users\\Admin\\Desktop\\lvqkhanh_Manager\\src\\assets\\image\\";

    @GetMapping("user")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
    }

    @GetMapping("roles")
    public ResponseEntity<?> getAllRoles(){
    	return new ResponseEntity<>(userService.getallRoles(), HttpStatus.ACCEPTED);
    }
  
    @PostMapping("user-search")
    public ResponseEntity<?> searchUser(@RequestBody String request){
        return new ResponseEntity<>(this.userService.searchUser(request),HttpStatus.CREATED) ;
    }
    @GetMapping("user-email/{email_id}")
    public ResponseEntity<?> fetchUserEntityByEmailId(@PathVariable  String email_id){
//    	try {
//			UserEntity userLogedIn = this.userService.fetchUserEntityByEmailId(request);
//			return new ResponseEntity<>(userLogedIn ,HttpStatus.CREATED);		
//		} catch (Exception e) {
//			return new ResponseEntity<>(null ,HttpStatus.BAD_REQUEST);	
//		}
    	 return new ResponseEntity<>(userService.fetchUserEntityByEmailId(email_id), HttpStatus.ACCEPTED);
    }
    
    @PostMapping("user")
    public ResponseEntity<?> AddUser(@RequestBody UserRequest userEntity){
        return new ResponseEntity<>(this.userService.AddUser(userEntity),HttpStatus.CREATED) ;
    }

    @PostMapping("user/upload/{id}")
    public ResponseEntity<?> UploadFile(@RequestParam MultipartFile file,@PathVariable Integer id){
        UserEntity entity = userDao.findById(id).get();
        String FileName = UploadSerVice.UploadOneFile(file,upload);
        entity.setAvatar(FileName);
        userDao.save(entity);
        return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<?>GetUserById(@PathVariable Integer id){
        UserEntity entity= userDao.findById(id).orElseThrow();
        return ResponseEntity.ok(entity);
    }

    //update
    @PutMapping("user/{id}")
    public ResponseEntity<?>UpdateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        
        return new ResponseEntity<>(this.userService.UpdateUser(userRequest, id),HttpStatus.ACCEPTED);
    }
   
    //delete
    @DeleteMapping("user/{id}")
    public Boolean DeleteUser(@PathVariable Integer id){
        userService.DeleteUser(id);
        return true;
    }

    //login
    @PostMapping("login")
    public  UserEntity LoginUserentity(@RequestBody UserEntity userEntity) throws Exception{
        String temp_email= userEntity.getEmailId();
        String temp_password=userEntity.getPassword();
        UserEntity userEntityObj = null;
        if(temp_email != null && temp_password != null){
            userEntityObj = userService.fetchUserEntityByEmailIdAndPassword(temp_email, temp_password);
        }
        if(userEntityObj == null){
            throw new Exception("Bad credentials");
        }
        return userEntityObj;
    }

    
}
