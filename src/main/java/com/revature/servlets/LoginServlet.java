package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceFake;

public class LoginServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = -2862417159526639895L;
private UserService userService = new UserServiceFake();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession sess = req.getSession(false);
		if(sess !=null && sess.getAttribute("user") != null) {
			//user is logged in already
//			resp.sendRedirect("home");
			resp.sendRedirect("supervisor");
		} else {
			//if user.type ==x, then different page
			resp.sendRedirect("login.html");
		}
		
		
	}
	
	//know this
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//getting this from Login form from client
		String username = req.getParameter("username");
		String password= req.getParameter("password");
		User user = userService.loginUser(username, password);
		

		UserDao ud = new UserDaoImpl();
		User u = ud.getUserByName(username);
		
		if (user == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed Login");
		} else {
			HttpSession sess = req.getSession(true);
			sess.setAttribute("user", user);
			sess.setAttribute("userid", u.getUserId());
			//if user.type ==x, then different page
//			resp.sendRedirect("home");
			resp.sendRedirect("supervisor");
		//	resp.getWriter().write("Successful Login");
		//	req.getRequestDispatcher("home").forward(req, resp);
		}
		
		
		
	}
}
