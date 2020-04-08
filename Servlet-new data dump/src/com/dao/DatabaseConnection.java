package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
static Connection con;
	
	public Connection getConnection() {
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			 // System.out.println("test1");
			 con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521/XEPDB1","jai","raj");  
			// System.out.println("test2");
			//con.close();  
			}catch(Exception e){ System.out.println(e);}  
		return con;
			}  
	
}
