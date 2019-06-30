package com.revature.dao;

import java.util.List;

import com.revature.pojo.ReimburseForm;
import com.revature.pojo.User;

public interface ReimbursementDao {
	
	public void insertForm(ReimburseForm r);
	
	
	public List<ReimburseForm> viewFormBySupervisorId(Integer id);
	
	public ReimburseForm getFormById(Integer reimburseid);
	
	public void supervisorApproveForm (Integer formid);

}
