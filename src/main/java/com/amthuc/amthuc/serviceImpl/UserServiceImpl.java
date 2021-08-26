package com.amthuc.amthuc.serviceImpl;

import com.amthuc.amthuc.dao.RoleDao;
import com.amthuc.amthuc.dao.UserDao;

import com.amthuc.amthuc.entity.Roles;
import com.amthuc.amthuc.entity.UserEntity;
import com.amthuc.amthuc.entity.UserRequest;
import com.amthuc.amthuc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<UserEntity> getAllUser()
    {
        return userDao.findAll();
    }

    @Override
    public UserEntity GetUserById(UserEntity entity) {
        return null;
    }

    @Override
	
    public UserEntity UpdateUser(UserRequest Request, Integer id)
    {
    	UserEntity userEntity =userDao.findById(id).orElseThrow();
    	userEntity.setUser_name(Request.getUser_name());
    	userEntity.setPassword(Request.getPassword());
    	userEntity.setAvatar(Request.getAvatar());
    	userEntity.setName(Request.getName());
    	userEntity.setEmailId(Request.getEmailId());
    	userEntity.setRole_id(roleDao.findById(Request.getRole_id()).orElseThrow());
        return userDao.save(userEntity);
    }
   
   

    @Override
    public UserEntity fetchUserEntityByEmailId(String email_id)
    {
//    	System.out.println("email" + email_id.split("\"")[1]);
//        return userDao.findByEmailId(email_id.split("\"")[1]);
    	return userDao.findByEmailId(email_id);
    }

    @Override
    public UserEntity fetchUserEntityByEmailIdAndPassword(String email_id, String password) {
        return userDao.findByEmailIdAndPassword(email_id, password);
    }

    @Override
    public void DeleteUser(Integer id)
    {
        userDao.deleteById(id);
    }

	@Override
	public List<Roles> getallRoles() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	    public UserEntity AddUser(UserRequest entity) {
	    	UserEntity newEntity = new UserEntity();
	    	Roles role = new Roles();      	
	    	newEntity.setPassword(entity.getPassword());
	    	newEntity.setEmailId(entity.getEmailId());
	    	newEntity.setUser_name(entity.getUser_name());
	    	newEntity.setName(entity.getName());
	    	
	    	Optional<Roles> optionalRole = roleDao.findById(entity.getRole_id());
	    	role = optionalRole.get();
	    	newEntity.setRole_id(role);
	        return userDao.save(newEntity);
	    }

	@Override
	public List<UserEntity> searchUser(String request) {
		return userDao.searchUser(request);
	}

	@Override
	public UserEntity GetUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
