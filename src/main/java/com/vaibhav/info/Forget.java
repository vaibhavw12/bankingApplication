package com.vaibhav.info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forget
 */
@WebServlet("/Forget")
public class Forget extends HttpServlet {
	public static Connection create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bankingApplication";
			String uname = "root";
			String pass = "@mysql";
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			return con;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String mobile = request.getParameter("mobile_num");
		String pan = request.getParameter("pan_num");
		
		if(pan.isEmpty() || mobile.length()!=10) {
			out.print("plz enter valid inforamation to update account details");
			out.print("<br><a href='login.jsp'>try again</a>");
		}else {
			String pass=checkExist(pan,mobile);
			if(pass!=null) {
				out.print("password recovered successfull ,");
				out.print("<br>");
				out.print("<br>-----------------<br>");
				out.print(pass);
				out.print("<br>-----------------<br>");
				out.print("<br>  <a href='login.jsp'>click here</a>");
			}else {
				out.print("something went wrong ,try again");
				out.print("  <a href='login.jsp'>click here</a>");
			}
		}
	}

	private String checkExist(String pan ,String mobile) {
		// TODO Auto-generated method stub
		Connection con = Forget.create();
		try {
			PreparedStatement psDemo=con.prepareStatement("select password from register1 where pan=? and mobile=?");
			psDemo.setString(1, pan);
			psDemo.setString(2, mobile);
			ResultSet rs = psDemo.executeQuery();
			if(rs.next()==false) {
				return null;
			}
			String pass=rs.getString(1);
			return pass;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
