package com.vaibhav.info;

import java.sql.*;

public class CostumerDao {
	
	
	//creating con refrence
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
	
	
	public static boolean save(CostumerInfo c) {
		Connection con = CostumerDao.create();
		int status = 0; 
		try {
			
			//value insert in database
			PreparedStatement ps=con.prepareStatement("insert into register1 (Name,Pan,Email,Mobile,Password) values(?,?,?,?,?)");
			ps.setString(1,c.getName());
			ps.setString(2, c.getPan());
			ps.setString(3,c.getEmail());
			ps.setString(4, c.getMobile());
			ps.setString(5, c.getPassword());
			//PreparedStatement ps=con.prepareStatement("insert into register1 (Name,Pan,Email,Mobile,Password) values ('v','SD','2@g','345','dsf')");
			//executing query
		    status= ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status==1) {
			return true;
		}else {
			return false;
		}
	
	}
}





