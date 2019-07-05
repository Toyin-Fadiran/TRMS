package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	private static Connection conn = ConnectionFactory.getConnection();

	public ArrayList<User> getAllUser() {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select username,pass_word from user_trms";

		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;

	}
	
	public void insertImage() {
		
		try {
		File file = new File("myimage.gif");
		FileInputStream fis = new FileInputStream(file);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO images_trms VALUES (?, ?)");
		ps.setString(1, file.getName());
		ps.setBinaryStream(2, fis, file.length());
		ps.executeUpdate();
		ps.close();
		fis.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByName(String username) {
		String sql = "select * from user_trms where username = '" + username + "'";
		User ret = null;
		Statement stmt;

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				ret = new User();

				ret.setUserId(rs.getInt(1));
				ret.setUsername((rs.getString(2)));
				ret.setPassword(rs.getString(3));
				ret.setReportsto(rs.getInt(4));
				ret.setTitle(rs.getString(5));
			}

			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	// update pending upon FIRST INSERT
	@Override
	public void addPending(Double pending, Integer userid) {
		try {
			// PreparedStatement pstmt = conn.prepareStatement("update project_car set
			// offer_flag = ? where carid = ?");
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set pending = ? where employeeid = ?;");
			pstmt.setDouble(1, pending);
			pstmt.setInt(2, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//		try {
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			if (rs.next()) {
//				ret = new Car();
//				// new Car(
//				ret.setCarID(rs.getInt(1));
//
//				ret.setCarID(rs.getInt(1));
//				ret.setName(rs.getString("car_name"));
//				ret.setPrice(rs.getDouble("car_price"));
//				ret.setForSale(rs.getBoolean("for_sale"));
//				ret.setOfferFlag(rs.getBoolean("offer_flag"));
//	
	@Override
	public Double getAvailable(Integer userid) {
		Double ret = null;

		try {
			// PreparedStatement pstmt = conn.prepareStatement("update project_car set
			// offer_flag = ? where carid = ?");
			PreparedStatement pstmt = conn.prepareStatement("select available from user_trms where employeeid = ?;");
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ret = rs.getDouble("available");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public void updateAvailable(Double available, Integer employeeid) {
		try {
			// PreparedStatement pstmt = conn.prepareStatement("update project_car set
			// offer_flag = ? where carid = ?");
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set available = ? where employeeid = ?;");
			pstmt.setDouble(1, available);
			pstmt.setInt(2, employeeid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Double getPending(Integer userid) {
		Double ret = null;

		try {
			// PreparedStatement pstmt = conn.prepareStatement("update project_car set
			// offer_flag = ? where carid = ?");
			PreparedStatement pstmt = conn.prepareStatement("select pending from user_trms where employeeid = ?;");
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ret = rs.getDouble("pending");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public User getUserbyformId(Integer formid) {
		User ret = null;

		try {
			
			PreparedStatement pstmt = conn.prepareStatement("select * from user_trms where employeeid in (select employeeid from reimbursement_trms where reimbursementid = ?);");
			pstmt.setInt(1, formid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ret = new User();
				ret.setUserId(rs.getInt("employeeid"));
				ret.setUsername(rs.getString("username"));
				ret.setPassword(rs.getString("pass_word"));
				ret.setReportsto(rs.getInt("reportsto"));
				ret.setTitle(rs.getString("title"));
				ret.setAvailable(rs.getDouble("available"));
				ret.setAwarded(rs.getDouble("awarded"));
				ret.setPending(rs.getDouble("pending"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public void setAward(Integer userID, Double award) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set awarded = ? where employeeid = ?;");
			pstmt.setDouble(1, award);
			pstmt.setInt(2, userID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addFinalPending(Double pending, Integer userid) {
		try {
		
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set pending = ? where employeeid = ?;");
			pstmt.setDouble(1, pending);
			pstmt.setInt(2, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Double getAwarded(Integer userid) {
		Double ret = null;

		try {
			// PreparedStatement pstmt = conn.prepareStatement("update project_car set
			// offer_flag = ? where carid = ?");
			PreparedStatement pstmt = conn.prepareStatement("select awarded from user_trms where employeeid = ?;");
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ret = rs.getDouble("awarded");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

//	public static void main(String[] args) {
//		UserDaoImpl udi = new UserDaoImpl();
//		System.out.println(udi.getUserByName("toyin"));
//		System.out.println(udi.getAvailable(1));
//	}

}
