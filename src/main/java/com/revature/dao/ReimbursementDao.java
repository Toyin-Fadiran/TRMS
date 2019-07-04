package com.revature.dao;

import java.util.List;

import com.revature.pojo.ReimburseForm;
import com.revature.pojo.User;

public interface ReimbursementDao {
	
	public void insertForm(ReimburseForm r);
	
	
	public List<ReimburseForm> viewFormBySupervisorId(Integer id);
	
	public List<ReimburseForm> viewFormByHead();
	
	public List<ReimburseForm> viewFormByBenco();
	
	public ReimburseForm getFormById(Integer reimburseid);
	
	public void supervisorApproveForm (Integer formid);
	
	public void headApproveForm(Integer formid);
	
	public void bencoApproveForm(Integer formid);
	
	
	
	
	public List<ReimburseForm> viewFormByEmployeeId(Integer id);
	
	
	public void updateProof(Integer formid, String proof);

	
	
	public List<ReimburseForm> viewFinalFormByBenco();
	
	
	
	
	public void bencoFinalApproveForm(Integer formid); 
	
	
}
