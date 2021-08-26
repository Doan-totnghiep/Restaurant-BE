package com.amthuc.amthuc.service;


import com.amthuc.amthuc.entity.Roles;
import com.amthuc.amthuc.entity.UserEntity;
import com.amthuc.amthuc.entity.UserRequest;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();
    List<UserEntity> searchUser(String request);
    List<Roles> getallRoles();
    UserEntity AddUser(UserRequest entityRequest);
    UserEntity GetUserById (UserEntity entity);
    UserEntity GetUserByEmail (String email);
    UserEntity UpdateUser(UserRequest entityRequest, Integer id);
    UserEntity fetchUserEntityByEmailId(String email_id);
    UserEntity fetchUserEntityByEmailIdAndPassword(String email_id ,String password);
    void DeleteUser(Integer id);
	
}
