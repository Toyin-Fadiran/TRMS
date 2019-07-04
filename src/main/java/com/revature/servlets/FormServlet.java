package com.revature.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojo.ReimburseForm;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	
	//private UserService userService = new UserServiceFake();
	ReimbursementDao rf = new ReimbursementDaoImpl();
	
	UserService us = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("rform.html");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//SimpleDateFormat sdfdate = new SimpleDateFormat("MM/dd/yyyy");
	//	SimpleDateFormat sdfdate2 = new SimpleDateFormat("MM/dd/yyyy");
		
		
		
		
		//date in String
		//String dateString = "2018-07-14T17:45:55.9483536";
		 
		//Build formatter
		//DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		//DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		         
		//Parse String to LocalDateTime
		
		 
		//Verify
		//System.out.println("Parsed LocalDateTime : " + dateTime);       
		 
		//Output:
		 
		//Parsed LocalDateTime : 2018-07-14T17:45:55.948353600
		
		String events = req.getParameter("events");
		String time = req.getParameter("time");
		String startdate = req.getParameter("startdate");
		String enddate = req.getParameter("enddate");
		
		Date sd = Date.valueOf(startdate);
		Date ed = Date.valueOf(enddate);
		
		
		String address = req.getParameter("address");
		Double cost = Double.parseDouble(req.getParameter("cost"));
		String gradeFormat = req.getParameter("grade-format");
		String description = req.getParameter("description");
		String work_justify = req.getParameter("description");
		
		
		HttpSession sess = req.getSession(false);
		if (sess == null || sess.getAttribute("user") ==null) {
			req.getRequestDispatcher("login").forward(req, resp);
			return;
		}
	
		Double pending	= us.calculatePend(cost, events);
		Integer userid = (Integer) sess.getAttribute("userid");
			
		us.addPending(pending, userid);
	
		
		//THIS IS INITIAL AVAILABLE FROM DATABASE
//		Double avail = us.getAvailable(userid);
		
		us.updateAvailable(pending, userid);
		rf.insertForm(new ReimburseForm((Integer)sess.getAttribute("userid"), sd, ed, address, description, cost, gradeFormat, events));
		resp.getWriter().write("<h1>Successfully Submitted Form!</h1>" + " </h1><br><a href=\"rform.html\">fill form</a><br> <a href=\"formupdate.html\">Update Forms<br><a href=\"logout\">logout</a>");
		
	}

}
