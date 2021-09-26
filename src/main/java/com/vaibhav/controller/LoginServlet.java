package com.vaibhav.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaibhav.info.BalanceInfo;
import com.vaibhav.info.CostumerDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	static String static_pan;
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
			session.setAttribute("unique",dao.pan_num);
			static_pan=dao.pan_num;
			response.sendRedirect("loginsuccess.jsp");
		}else {
			out.print("plz enter correct crenditials  ,try again");
			out.print("  <a href='login.jsp'>click here</a>");
		}
		
	}
	public static int checkBalance() {
		Connection con = BalanceInfo.create();
		try {
			PreparedStatement psDemo=con.prepareStatement("select Balance from register1 where pan=?");
			psDemo.setString(1,static_pan);
			ResultSet rsDemo = psDemo.executeQuery();
			rsDemo.next();
			int balance=(int)Integer.parseInt(rsDemo.getString(1));
			
			return balance;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static ArrayList viewDetails() {
		Connection con = BalanceInfo.create();
		ArrayList<String> list = new ArrayList();
		try {
			PreparedStatement psDemo=con.prepareStatement("select * from register1 where pan=?");
			psDemo.setString(1,static_pan);
			ResultSet rsDemo = psDemo.executeQuery();
			rsDemo.next();
			list.add(rsDemo.getString(1));
			list.add(rsDemo.getString(2));
			list.add(rsDemo.getString(3));
			list.add(rsDemo.getString(4));
			list.add(rsDemo.getString(5));
			list.add(rsDemo.getString(6));
			list.add(rsDemo.getString(7));
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	return list;
		return list;
	}

}
