package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ReimburseForm;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class ReimbursementDaoImpl implements ReimbursementDao {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void insertForm(ReimburseForm r) {
		try {
			conn.setAutoCommit(false);
			String query = "insert into reimbursement_trms(address_location,"
					+ "description,course_cost,grading_format,events,startdate, enddate, employeeid) values"
					+ "(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, r.getAddress());
			pstmt.setString(2, r.getDescription());
			pstmt.setDouble(3, r.getCourse_cost());
			pstmt.setString(4, r.getGrading_format());
			pstmt.setString(5, r.getEvents());
			pstmt.setDate(6, (Date) r.getStartdate());
			pstmt.setDate(7, (Date) r.getEnddate());
			pstmt.setInt(8, r.getEmployeeID());

			pstmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public List<ReimburseForm> viewFormBySupervisorId(Integer id) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();
		
		String sql = "select * from reimbursement_trms where status = 'pending-1'";



		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("reimbursementId"), rs.getInt("employeeid"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"),
						rs.getString("status"), rs.getString("grading_format"), rs.getString("events"),
						rs.getString("work_justify")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return formList;
	}

	@Override
	public ReimburseForm getFormById(Integer reimburseid) {
		ReimburseForm ret = null;

		String sql = "select * from reimbursement_trms where reimbursementid =" + reimburseid;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new ReimburseForm(rs.getInt("reimbursementId"), rs.getInt("employeeid"), rs.getDate("startdate"),
						rs.getDate("enddate"), rs.getString("form_time"), rs.getString("address_location"),
						rs.getString("description"), rs.getDouble("course_cost"), rs.getString("status"),
						rs.getString("grading_format"), rs.getString("events"), rs.getString("work_justify"), rs.getString("proof"));

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void supervisorApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update reimbursement_trms set status = 'pending-2' where reimbursementid = ?");

			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void headApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update reimbursement_trms set status = 'pending-3' where reimbursementid = ?");

			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void bencoApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update reimbursement_trms set status = 'approveA' where reimbursementid = ?");

			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public List<ReimburseForm> viewFormByHead() {
		ArrayList<ReimburseForm> formList = new ArrayList<>();
		
		String sql = "select * from reimbursement_trms where status = 'pending-2'";

//		String sql = "select * from reimbursement_trms where status = 'pending-2' "
//				+ "and employeeid in (select e.employeeid from user_trms e "
//				+ "inner join user_trms s on e.reportsto = s.employeeid)";

		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("reimbursementId"), rs.getInt("employeeid"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"),
						rs.getString("status"), rs.getString("grading_format"), rs.getString("events"),
						rs.getString("work_justify")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return formList;
	}

	@Override
	public List<ReimburseForm> viewFormByBenco() {
		ArrayList<ReimburseForm> formList = new ArrayList<>();
		
		String sql = "select * from reimbursement_trms where status = 'pending-3'";

//		String sql = "select * from reimbursement_trms where status = 'pending-3' "
//				+ "and employeeid in (select e.employeeid from user_trms e "
//				+ "inner join user_trms s on e.reportsto = s.employeeid)";

		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("reimbursementId"), rs.getInt("employeeid"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"),
						rs.getString("status"), rs.getString("grading_format"), rs.getString("events"),
						rs.getString("work_justify")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return formList;
	}

	@Override
	public List<ReimburseForm> viewFormByEmployeeId(Integer id) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();

		String sql = "select * from reimbursement_trms where status = 'approveA' and employeeid = " + id;

		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("reimbursementId"), rs.getInt("employeeid"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"),
						rs.getString("status"), rs.getString("grading_format"), rs.getString("events"),
						rs.getString("work_justify"), rs.getString("proof")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return formList;
	}

	@Override
	public void updateProof(Integer formid, String proof) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update reimbursement_trms set proof = ? where reimbursementid = ?");

			pstmt.setString(1, proof);
			pstmt.setInt(2, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public List<ReimburseForm> viewFinalFormByBenco() {
		ArrayList<ReimburseForm> formList = new ArrayList<>();

		String sql = "select * from reimbursement_trms where status = 'approveA'";

		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("reimbursementId"), rs.getInt("employeeid"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"),
						rs.getString("status"), rs.getString("grading_format"), rs.getString("events"),
						rs.getString("work_justify"), rs.getString("proof")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return formList;
	}

	@Override
	public void bencoFinalApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update reimbursement_trms set status = 'approveZ' where reimbursementid = ?");

			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
}

//public static void main(String[] args) {
//	User u = new User();
//	ReimbursementDaoImpl rd = new ReimbursementDaoImpl();
//	System.out.println(rd.viewFormBySupervisor(u));
//}
