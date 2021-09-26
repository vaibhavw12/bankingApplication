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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DepositInfo
 */
@WebServlet("/DepositInfo")
public class DepositInfo extends HttpServlet {
	
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
	String pan_num,name;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String withdraw = request.getParameter("balance");
		
		HttpSession session = request.getSession();
		name =(String) session.getAttribute("name");
		pan_num = (String) session.getAttribute("unique");
		
		String deposit = request.getParameter("deposit");
		if(depositAmount(deposit)) {
			out.print("transction successfull");
			out.print("<br> <a href='loginsuccess.jsp'>dashboard</a>");
		}else {
			out.print("transction unsuccessfull");
			out.print("<br> <a href='loginsuccess.jsp'>try again</a>");
		}
		
	}
	int status=0;
	private boolean depositAmount(String deposit) {
		// TODO Auto-generated method stub
		Connection con = DepositInfo.create();
		try {
			PreparedStatement psDemo=con.prepareStatement("select Balance from register1 where pan=?");
			psDemo.setString(1,pan_num);
			ResultSet rsDemo = psDemo.executeQuery();
			rsDemo.next();
			int balance=(int)Integer.parseInt(rsDemo.getString(1));
			
			balance=balance+(int)Integer.parseInt(deposit);
		//	System.out.println(balance);
			PreparedStatement ps=con.prepareStatement("update register1 set Balance=? where pan=?");
			ps.setString(1,balance+"");
			ps.setString(2,pan_num);
			status = ps.executeUpdate();
			if(status==1) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
