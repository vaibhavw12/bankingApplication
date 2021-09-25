package com.vaibhav.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaibhav.info.CostumerDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String pan = request.getParameter("pan");
		String password = request.getParameter("password");
		
		CostumerDao dao = new CostumerDao();
		if(dao.check(pan,password)) {
			//out.print("login successfull");
			HttpSession session = request.getSession();
			session.setAttribute("name",dao.name);
			response.sendRedirect("loginsuccess.jsp");
		}else {
			out.print("try again");
		}
		
	}

}
