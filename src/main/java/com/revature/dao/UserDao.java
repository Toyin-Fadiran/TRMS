package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.User;

public interface UserDao {
	
	public ArrayList<User> getAllUser();
	
	public User getUserByName(String username);
	
	public void addPending(Double pending, Integer userid);
	
	public Double getAvailable(Integer userid);
	
	public Double getPending(Integer userid);
	
	public void updateAvailable(Double available, Integer employeeid);
	
	
	public User getUserbyformId(Integer formid);
	
	public void setAward(Integer userID, Double award);
	
	public void addFinalPending(Double pending, Integer userid);

}
