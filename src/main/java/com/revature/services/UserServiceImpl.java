package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

public class UserServiceImpl implements UserService {

	private static UserDaoImpl udi = new UserDaoImpl();
	ReimburseService rd = new ReimburseServiceImpl();
	private List<User> userDao;
	private User user;

	public User loginUser(String username, String password) {
		// System.out.println("username: " + username);
		// System.out.println("password: " + password);

		User user = null;

		for (User check : udi.getAllUser()) {
			// for (User check: userDao ) {
			if (check.getUsername().equals(username) && check.getPassword().equals(password)) {
				user = check;
				break;
			}
		}
		return user;
	}

	@Override
	public User getUserByName(String username) {

		return udi.getUserByName(username);
	}

	@Override
	public Double calculatePend(Double cost, String events) {
		Double pending = null;

		switch (events) {
		case "university-courses":
			pending = .8 * cost;
			break;
		case "certification-prep-classes":
			pending = .75 * cost;
			break;
		case "certification":
			pending = cost;
			break;
		case "technical-training":
			pending = .9 * cost;
			break;
		case "seminars":
			pending = .6 * cost;
			break;
		case "other":
			pending = .3 * cost;
			break;

		}

		return pending;

	}

	@Override
	public void addPending(Double pending, Integer userid) {
		// Double newPend;

		Double newPend = pending + udi.getPending(userid);

		udi.addPending(newPend, userid);

	}

	@Override
	public Double getAvailable(Integer userid) {

		return udi.getAvailable(userid);
	}

	@Override
	public void updateAvailable(Double pending, Integer employeeid) {
		Double newAvail;

		Double getPend = getPending(employeeid);
		
		Double getAward = getAwarded(employeeid); 

		//Double oldAvail = getAvailable(employeeid);

		newAvail = user.getTotal() - getPend - getAward;

		udi.updateAvailable(newAvail, employeeid);
	}

	@Override
	public Double getPending(Integer userid) {
		return udi.getPending(userid);
	}
	
	@Override
	public Double getAwarded(Integer userid) {
		return udi.getAwarded(userid);
	}

	@Override
	public User getUserbyformId(Integer formid) {
		return udi.getUserbyformId(formid);
	}

	@Override
	public void setAward(Integer fid) {
		double award = udi.getUserbyformId(fid).getAwarded();

		System.out.println("firrst award "+award);
		
		Double costDB = rd.getFormById(fid).getCourse_cost();

		System.out.println("costDB "+costDB);
		// 2) column "pending"
		Double pendingDB = udi.getUserbyformId(fid).getPending();

		System.out.println("pendingDB "+pendingDB);
		// 3) column available
		Double availableDB = udi.getUserbyformId(fid).getAvailable();

		System.out.println("availableDB "+availableDB);
		// getuserid
		Integer userID = udi.getUserbyformId(fid).getUserId();
		
		System.out.println("useris " + userID);

		if (pendingDB >= availableDB) {
			award += availableDB;
		} else {
			award += pendingDB;
		}

		System.out.println("2nd award "+award);
		//Double newpendingReturn = pendingDB - award;
		Double newpendingReturn = user.getTotal() - availableDB - award;
		System.out.println("newpendingReturn "+newpendingReturn);
		
		addFinalPending(newpendingReturn, userID);

		
		
		Double newAvailableReturn = user.getTotal() - award - newpendingReturn;
		udi.updateAvailable(newAvailableReturn, userID);
		System.out.println("newAvailableReturn "+newAvailableReturn);
		udi.setAward(userID, award);
	}

	@Override
	public void addFinalPending(Double pending, Integer userid) {
		
		udi.addFinalPending(pending, userid);
		
	}

//	public static void main(String[] args) {
//		UserService usa = new UserServiceImpl();
//		 usa.setAward(22);
//	}
	
}
