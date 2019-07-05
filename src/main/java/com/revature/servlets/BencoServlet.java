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

/**
 * Servlet implementation class BencoServlet
 */
public class BencoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
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

			List<ReimburseForm> viewList = rd.viewFormByBenco();
			System.out.println("this is our " + viewList);

			String result = "";

			for (ReimburseForm r : viewList) {
				result +="form number: " + r.getReimbursementId() + " ";
			}
			
			response.getWriter().append(result);
			return;
		}

		System.out.println(name.substring(1));
		Integer id = Integer.parseInt(name.substring(1));
		ReimburseForm a = rd.getFormById(id);

		ObjectMapper om = new ObjectMapper();
		

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		om.setDateFormat(df);


		

		
		String formString = om.writeValueAsString(a);
		
		System.out.println("this is "+formString);
		response.getWriter().write(formString);

		
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
			rd.bencoApproveForm(fid);
			response.getWriter().write("Form approved");
			response.getWriter().write("<h1>Form Successfully Approved!</h1>" + " <br><a href=\"bencoform.html\">Benco Form Approval</a><br><a href=\"logout\">logout</a>");
		} else {
			System.out.println("hello");
		}

	



















		//		String name = request.getPathInfo();
		//		System.out.println(name.substring(1));
		//	Integer id = Integer.parseInt(name.substring(1));
		//ReimburseForm a = rd.getFormById(id);

		//updateForm(a);



		//		String body = request.getReader().readLine();
		//		System.out.println(body);
		//	ObjectMapper om = new ObjectMapper();
		//	Animal a = om.readValue(body, Animal.class);
		//	a.setOwner((User)sess.getAttribute("user"));
		//	as.createAnimal(a);
		//	response.getWriter().write("Animal successfuly created");
	}

}