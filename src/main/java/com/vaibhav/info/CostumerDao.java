package com.vaibhav.info;

import java.sql.*;

public class CostumerDao {
//	public static void main(String [] args) {
//		System.out.println("hello");
//		System.out.println(CostumerDao.check("S","dsf"));
//	}
	
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
	
	
	public boolean save(CostumerInfo c) {
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

	public boolean check(String pan , String password) {
		// TODO Auto-generated method stub
		Connection con = CostumerDao.create();
		
		try {
			PreparedStatement ps=con.prepareStatement("select pan,password from register1 where pan=? and password=?");
			ps.setString(1,pan);
			ps.setString(2,password);
		//	System.out.println(ps.executeUpdate());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}





