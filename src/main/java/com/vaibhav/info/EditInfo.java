package com.vaibhav.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaibhav.controller.LoginServlet;

/**
 * Servlet implementation class EditInfo
 */
@WebServlet("/EditInfo")
public class EditInfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		if(password.isEmpty() || mobile.length()!=10 || email.isEmpty()) {
			out.print("plz enter valid inforamation to update account details");
			out.print("<br><a href='editdetails.jsp'>try again</a>");
		}else {
			int update =LoginServlet.editDetails(email,mobile,password);
			if(update==1) {
				out.print("credentials updated successfully");
				out.print("<br> <a href='loginsuccess.jsp'>dashboard</a>");
			}else {
				out.print("something went wrong ,try again");
				out.print("<br> <a href='loginsuccess.jsp'>try again</a>");
			}
		}
		
		
	}

}
