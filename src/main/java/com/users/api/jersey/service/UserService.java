package com.users.api.jersey.service;

 

 
import java.util.List;

import com.users.api.jersey.model.Users;

 


public interface UserService {
	
	
	
	  Users addUser(Users user);

	  Users updateUser( Long uid, Users user);
	  
	  List<Users> getUsers(String keyword, int fetchSize);

	  void deleteUser(Long uid);

	boolean isUserExist(Long uid);

}
