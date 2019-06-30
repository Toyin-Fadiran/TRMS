package com.revature.dao;

import java.sql.Connection;
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
	 
		@Override
		public User getUserByName(String username) {
			String sql = "select * from user_trms where username = '" +  username +  "'";
			User ret = null;
			Statement stmt;
			
			try {
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					ret = new User();
				
					ret.setUserId(rs.getInt(1));
					ret.setUsername((rs.getString(2)));
					ret.setPassword(rs.getString(3));
					ret.setReportsto(rs.getInt(4));
					ret.setTitle(rs.getString(5));
				}
				
				conn.commit();
				conn.setAutoCommit(true);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return ret;
		}

//
//	public static void main(String[] args) {
//		UserDaoImpl udi = new UserDaoImpl();
//		System.out.println(udi.getUserByName("toyin"));
//		//System.out.println("hello");
//	}

}
