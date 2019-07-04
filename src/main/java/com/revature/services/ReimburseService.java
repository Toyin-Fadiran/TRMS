package com.revature.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ReimburseForm;

public interface ReimburseService {
	
	public List<ReimburseForm> viewFormBySupervisorId(Integer id);
	
	public ReimburseForm getFormById(Integer reimburseid);
	
	public void supervisorApproveForm(Integer formid);
	
	
	public List<ReimburseForm> viewFormByHead();
	
	public void headApproveForm(Integer formid);
	
	public List<ReimburseForm> viewFormByBenco();
	
	public void bencoApproveForm(Integer formid);
	
	
	//EVERYTHING UNDERNEATH DEALS WITH 2ND PART OF HAPPY PATH
	public List<ReimburseForm> viewFormByEmployeeId(Integer id);

	
	
	
	
	public void updateProof(Integer formid, String proof);
	
	
	public List<ReimburseForm> viewFinalFormByBenco();
	
	public void bencoFinalApproveForm(Integer formid);

}
