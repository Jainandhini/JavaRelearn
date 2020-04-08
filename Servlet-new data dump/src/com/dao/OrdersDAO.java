package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pojo.*;

public class OrdersDAO {
	
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement ps=null;
	//Orders ordersList[]=null;
	ArrayList<Orders> ordersList=null;
	DatabaseConnection dconn;
	
	public OrdersDAO(){
		dconn=new DatabaseConnection();
	}
	
	public ArrayList<Orders> viewOrdersByUser(String custID) {
		con=dconn.getConnection();
		ordersList=new ArrayList<Orders>();
		
		try {
			ps= con.prepareStatement("SELECT * FROM ORDERS WHERE CUSTOMER_ID=?");
			//System.out.println("test3");
			ps.setString(1, custID);
			rs=ps.executeQuery();
			//System.out.println("test4");
			
			while(rs.next()){
				Orders o=new Orders();
				o.setOrder_id(rs.getString("ORDER_ID"));
				o.setCustomer_id(rs.getString("CUSTOMER_ID"));
				o.setOrder_date(rs.getString("ORDER_DATE"));
				o.setStatus(rs.getString("STATUS"));
				o.setSalesman_id(rs.getString("SALESMAN_ID"));
				ordersList.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if(con!=null) con.close();
					if(ps!=null) ps.close();
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
				
		return ordersList;
	}
	public ArrayList<Orders> viewOrdersFilterByStatus(String custID,String[] status) {
		con=dconn.getConnection();
		ordersList=new ArrayList<Orders>();
		
		
		try {
			StringBuffer str=new StringBuffer("SELECT * FROM ORDERS WHERE CUSTOMER_ID=");
			str.append(custID).append(" AND STATUS IN (");
			for(String stat:status) {
				str.append("'").append(stat).append("'").append(",");
			}
			str.deleteCharAt(str.length()-1).append(")");
			String query=str.toString();
			System.out.println("ps query: "+query);
			ps=con.prepareStatement(query);
			/*ps= con.prepareStatement("SELECT * FROM ORDERS WHERE CUSTOMER_ID=?"
					+ "AND STATUS IN (?)");
			//System.out.println("test3");
			ps.setString(1, custID);
			ps.setArray(2, con.createArrayOf("varchar", status));*/
			rs=ps.executeQuery();
			//System.out.println("test4");
			
			while(rs.next()){
				System.out.println("inside rs");
				Orders o=new Orders();
				o.setOrder_id(rs.getString("ORDER_ID"));
				o.setCustomer_id(rs.getString("CUSTOMER_ID"));
				o.setOrder_date(rs.getString("ORDER_DATE"));
				o.setStatus(rs.getString("STATUS"));
				o.setSalesman_id(rs.getString("SALESMAN_ID"));
				ordersList.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if(con!=null) con.close();
					if(ps!=null) ps.close();
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
				
		return ordersList;
	}

}
