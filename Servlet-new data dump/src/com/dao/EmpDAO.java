package com.dao;

import java.sql.*;

public class EmpDAO {
	DatabaseConnection dconn;
	
	public EmpDAO(){
		dconn=new DatabaseConnection();
	}
	
public String getSampleData(String id) {
	ResultSet rs=null;
	Connection conn=null;
	Statement stmt =null;
	String name=null;
		
	try {
       
        
         conn = dconn.getConnection();
         stmt = conn.createStatement();
        String sql;
        sql = "SELECT FIRST_NAME, LAST_NAME FROM Employees where employee_id="+id;
         rs = stmt.executeQuery(sql);

        // Extract data from result set
        while(rs.next()){
           //Retrieve by column name
          
           String first = rs.getString("FIRST_NAME");
           String last = rs.getString("LAST_NAME");
           name=first+" "+last;
          
        }
       

        // Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
     } catch(SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
     } catch(Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
     } finally {
        //finally block used to close resources
        try {
           if(stmt!=null)
              stmt.close();
        } catch(SQLException se2) {
        } // nothing we can do
        try {
           if(conn!=null)
           conn.close();
        } catch(SQLException se) {
           se.printStackTrace();
        } //end finally try
     } //end try
	return name;
  } 
	
	
}

