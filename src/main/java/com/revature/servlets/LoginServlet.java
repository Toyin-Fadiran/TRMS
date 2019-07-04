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
import com.revature.services.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2862417159526639895L;
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession sess = req.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) {
			// user is logged in already
			//			resp.sendRedirect("home");
			resp.sendRedirect("supervisor");
		} else {
			// if user.type ==x, then different page
			resp.sendRedirect("login.html");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// getting this from Login form from client
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.loginUser(username, password);

		//UserDao ud = new UserDaoImpl();
		
		User u = userService.getUserByName(username);
		
		//System.out.println(u);

		if (user == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed Login");
		} else {
			// this allows us to use throughout web app, HTTPP is stateless remember.
			HttpSession sess = req.getSession(true);
			sess.setAttribute("user", user);
			sess.setAttribute("userid", u.getUserId());
			sess.setAttribute("title", u.getTitle());

			// System.out.println(u.getTitle());
			if (u.getTitle().contains("Supervisor")) {
				resp.getWriter().write("<h1>Welcome " + u.getTitle()
				+ " </h1><br><a href=\"formfind.html\">Supervisor Approval</a><br><a href=\"logout\">logout</a>");
			} else if ((u.getTitle().contains("Head"))) {
				resp.getWriter().write("<h1>Welcome " + u.getTitle() + " </h1><br><a href=\"headform.html\">view forms</a><br><a href=\"logout\">logout</a>");
				//resp.getWriter().write("Head");

			} else if ((u.getTitle().contains("Benco"))) {
				resp.getWriter().write("<h1>Welcome " + u.getTitle() + " </h1><br><a href=\"bencoform.html\">view forms</a><br><a href=\"finalbencoform.html\">view final approval forms</a><br><a href=\"logout\">logout</a>");

			} else {
				resp.getWriter().write("<h1>Welcome " + u.getTitle()
				+ " </h1><br><a href=\"rform.html\">fill form</a><br> <a href=\"formupdate.html\">Update Forms<br><a href=\"logout\">logout</a>");
			}
		}

	}
}
