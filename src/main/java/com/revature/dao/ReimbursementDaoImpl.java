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
//			String query = "insert into reimbursement_trms(employeeid,form_date,form_time,address_location,"
//					+ "description,course_cost,grading_format,events,work_justify,event_attachment) values"
//					+ "(?,?,?,?,?,?,?,?,?,?)";
			
//			String query = "insert into reimbursement_trms(address_location,"
//					+ "description,course_cost,grading_format,events,startdate, enddate, form_time) values"
//					+ "(?,?,?,?,?,?,?,?)";
			
			String query = "insert into reimbursement_trms(address_location,"
					+ "description,course_cost,grading_format,events,startdate, enddate, employeeid) values"
					+ "(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, r.getEmployeeID());
//			pstmt.setTimestamp(2, r.getForm_date());
//			pstmt.setTime(3, r.getForm_time());
//			pstmt.setString(4, r.getAddress());
//			pstmt.setString(5, r.getDescription());
//			pstmt.setDouble(6, r.getCourse_cost());
//			pstmt.setString(7, r.getGrading_format());
//			pstmt.setString(8, r.getEvents());
//			pstmt.setString(9, r.getGrading_format());
//			pstmt.setString(10, r.getEvent_attachment());
			

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
			//LoggingUtil.info("Submitted a form");
		} catch (SQLException e) {
			//LoggingUtil.info("SQLException");
			e.printStackTrace();
		}

	}

	@Override
	public List<ReimburseForm> viewFormBySupervisorId(Integer id) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();

	String sql = "select * from reimbursement_trms where employeeid in (select e.employeeid from user_trms e inner join user_trms s on e.reportsto = s.employeeid where e.reportsto =" + id + ");";
		
		
		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("reimbursementId"),rs.getInt("employeeid"), rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"), rs.getString("status"),
						rs.getString("grading_format"), rs.getString("events"), rs.getString("work_justify")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formList;
	}

//public static void main(String[] args) {
//	User u = new User();
//	ReimbursementDaoImpl rd = new ReimbursementDaoImpl();
//	System.out.println(rd.viewFormBySupervisor(u));
//}
}
