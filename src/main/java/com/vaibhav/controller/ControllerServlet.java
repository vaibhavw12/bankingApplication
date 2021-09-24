package com.vaibhav.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaibhav.info.*;
/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//getting parameters from the user
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		String name=request.getParameter("name");
		String pan=request.getParameter("pan");
		String email=request.getParameter("email");
		
		
		if(password.isEmpty() || mobile.length()!=10 || pan.isEmpty() || name.isEmpty() || email.isEmpty()) {
			out.print("plz enter valid inforamation to set up an account");
			out.print("<br><a href='signun.jsp'>try again</a>");
		}else {
			//creating costumer object to save details
			CostumerInfo costumer = new CostumerInfo();
			costumer.setName(name);
			costumer.setPan(pan);
			costumer.setMobile(mobile);
			costumer.setEmail(email);
			costumer.setPassword(password);
			
			//passing costumer object to CostumerDao.save() method 
			
			CostumerDao dao = new CostumerDao();
			dao.save(costumer);
			
			
		}
	}

}
