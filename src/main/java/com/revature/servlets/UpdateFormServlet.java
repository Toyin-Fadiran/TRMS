package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.ReimburseForm;
import com.revature.pojo.User;
import com.revature.services.ReimburseService;
import com.revature.services.ReimburseServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;


public class UpdateFormServlet extends HttpServlet {
	
	private ReimburseService rs = new ReimburseServiceImpl();
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		String name = request.getPathInfo();
		
		if (name == null || name.substring(1) == "") {

			
			Integer userid = (Integer) sess.getAttribute("userid");
		
			List<ReimburseForm> formList = rs.viewFormByEmployeeId(userid);

			String result = "";

			for (ReimburseForm r : formList) {
				result +="form number: " + r.getReimbursementId() + " ";
			}
			//response.getWriter().write("<h1>" + result + "</h1>");
			response.getWriter().append(result);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		String proof = request.getParameter("proof");
		String formid = request.getParameter("formid");
		
		Integer fid =Integer.parseInt(formid);
	
		rs.updateProof(fid, proof);
		

	}

}
