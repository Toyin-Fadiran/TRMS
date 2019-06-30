package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.User;

public interface UserDao {
	
	public ArrayList<User> getAllUser();
	
	public User getUserByName(String username);
	

}
