
package com.revature.servlets;

import java.io.IOException;
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
import com.revature.pojo.User;



/**
 * Servlet implementation class AnimalServlet
 */
public class SupervisorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReimbursementDao rd = new ReimbursementDaoImpl();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

			
			List<ReimburseForm> formList = rd.viewFormBySupervisorId(userid);

			String result = "";

			for (ReimburseForm r : formList) {
				result +="formnumber: " + r.getReimbursementId() + " ";
			}
			response.getWriter().write("<h1>" + result + "</h1>");
			response.getWriter().append(result);
			return;
		}
//		System.out.println(name.substring(1));
//		ReimburseForm a = rd..getAnimalByName(name.substring(1));
//		System.out.println(a);
		/*
		 * response.getWriter().write( "{\"name\":\"" + a.getName() +
		 * "\", \"breed\":\""+a.getBreed() + "\", \"color\":\""+a.getColor() +
		 * "\", \"age\":"+a.getAge() + "}" );
		 */
	//	ObjectMapper om = new ObjectMapper();
	//	String animalString = om.writeValueAsString(a);
	//	response.getWriter().write(animalString);

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
		String body = request.getReader().readLine();
		System.out.println(body);
		ObjectMapper om = new ObjectMapper();
	//	Animal a = om.readValue(body, Animal.class);
	//	a.setOwner((User)sess.getAttribute("user"));
	//	as.createAnimal(a);
		response.getWriter().write("Animal successfuly created");
	}

}
