package com.revature.services;

import com.revature.pojo.User;

public interface UserService {

	public User loginUser(String username, String password);
	
	public User getUserByName(String username); 
	
	public Double calculatePend(Double cost, String events);
	
	//calculate current pending
	public void addPending(Double pending, Integer userid);
	
	public Double getAvailable(Integer userid);
	
	public Double getPending(Integer userid);
	
	
	public void updateAvailable(Double pending, Integer employeeid);
	
	
	
	
	public User getUserbyformId(Integer formid);
	
	
	
	
	public void setAward( Integer userid);
	
	
	public void addFinalPending(Double pending, Integer userid);
}
