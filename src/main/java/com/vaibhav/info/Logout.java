package com.vaibhav.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
	//	System.out.println(session.getAttribute("name"));
	//	System.out.println(session.getAttribute("unique"));
		session.removeAttribute("name");
		session.removeAttribute("unique");
	//	System.out.println(session.getAttribute("name"));
	//	System.out.println(session.getAttribute("unique"));
		session.invalidate();
		response.sendRedirect("index.html");
	}

}
