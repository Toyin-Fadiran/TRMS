package com.revature.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojo.ReimburseForm;

public class ReimburseServiceImpl implements ReimburseService {

	ReimbursementDao rd = new ReimbursementDaoImpl();

	@Override
	public List<ReimburseForm> viewFormBySupervisorId(Integer id) {

		return rd.viewFormBySupervisorId(id);
	}

	@Override
	public ReimburseForm getFormById(Integer reimburseid) {

		return rd.getFormById(reimburseid);
	}

	@Override
	public void supervisorApproveForm(Integer formid) {

		rd.supervisorApproveForm(formid);
	}

	@Override
	public List<ReimburseForm> viewFormByHead() {

		return rd.viewFormByHead();
	}

	@Override
	public void headApproveForm(Integer formid) {

		rd.headApproveForm(formid);

	}

	@Override
	public List<ReimburseForm> viewFormByBenco() {
		// TODO Auto-generated method stub
		return rd.viewFormByBenco();
	}

	@Override
	public void bencoApproveForm(Integer formid) {

		rd.bencoApproveForm(formid);

	}

	@Override
	public List<ReimburseForm> viewFormByEmployeeId(Integer id) {

		return rd.viewFormByEmployeeId(id);

	}

	@Override
	public void updateProof(Integer formid, String proof) {

		rd.updateProof(formid, proof);

	}

	@Override
	public List<ReimburseForm> viewFinalFormByBenco() {
		// TODO Auto-generated method stub
		return rd.viewFinalFormByBenco();
	}

	@Override
	public void bencoFinalApproveForm(Integer formid) {
		
		rd.bencoFinalApproveForm(formid);
		
	}

}