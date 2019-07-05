package com.revature.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.ReimburseForm;
import com.revature.services.ReimburseService;
import com.revature.services.ReimburseServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class FinalBencoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ReimburseService rd = new ReimburseServiceImpl();
	UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		String name = request.getPathInfo();

		if (name == null || name.substring(1) == "") {

			

			List<ReimburseForm> viewList = rd.viewFinalFormByBenco();
			System.out.println(viewList);

			String result = "";

			for (ReimburseForm r : viewList) {
				result +="form number: " + r.getReimbursementId() + " ";
			}
			
			response.getWriter().append(result);
			return;
		}

		
		Integer id = Integer.parseInt(name.substring(1));
		ReimburseForm a = rd.getFormById(id);

		ObjectMapper om = new ObjectMapper();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		om.setDateFormat(df);

		String formString = om.writeValueAsString(a);
		
		System.out.println("this is "+formString);
		response.getWriter().write(formString);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}

		String ap = "approved";
		String dn = "denied";

		String formid = request.getParameter("formid");
		Integer fid = Integer.parseInt(formid);

		String status = request.getParameter("status");


		if (status.equals(ap)) {
		
			//get USERID
			Integer userid = us.getUserbyformId(fid).getUserId();
			
			//set FINAL FInal AWARD
			us.setAward(fid);
			
			
			rd.bencoFinalApproveForm(fid);
			response.getWriter().write("<h1>Form Successfully Approved!</h1>" + " <br><a href=\"finalbencoform.html\">Final Benco Approval</a><br><a href=\"logout\">logout</a>");
			
			
			
		} else {
			System.out.println("hello");
		}


	}

}
