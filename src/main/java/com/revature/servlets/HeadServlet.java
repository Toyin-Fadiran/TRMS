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
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojo.ReimburseForm;
import com.revature.services.ReimburseService;
import com.revature.services.ReimburseServiceImpl;

public class HeadServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = -3091866423899639820L;
	//ReimbursementDao rd = new ReimbursementDaoImpl();
	ReimburseService rd = new ReimburseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		String name = request.getPathInfo();
		
		if (name == null || name.substring(1) == "") {

			//User user = (User) sess.getAttribute("user");
			Integer userid = (Integer) sess.getAttribute("userid");
			
			//this comment is designed to test git upstream

			
			List<ReimburseForm> viewList = rd.viewFormByHead();
			System.out.println("this is our " + viewList);

			String result = "";

			for (ReimburseForm r : viewList) {
				result +="form number: " + r.getReimbursementId() + " ";
			}
			//response.getWriter().write("<h1>" + result + "</h1>");
			response.getWriter().append(result);
			return;
		}
		
		System.out.println(name.substring(1));
		Integer id = Integer.parseInt(name.substring(1));
		ReimburseForm a = rd.getFormById(id);
		
		ObjectMapper om = new ObjectMapper();
		//2019-06-28
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		om.setDateFormat(df);
		
		
		//response.getWriter().write
	
		//String dateString = om.writeValueAsString(a.getEnddate());
		String formString = om.writeValueAsString(a);
		//String total = formString + startDate + endDate;
		System.out.println("this is "+formString);
		response.getWriter().write(formString);
		
		//om.setd
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
			rd.headApproveForm(fid);
			response.getWriter().write("Form approved");
		} else {
			System.out.println("hello");
		}
		
	
		
		
	}
}
