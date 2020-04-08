package com.display;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.Orders;

public class OrdersDisplay {
	
	public void displayOrders(PrintWriter out,ArrayList<Orders> orders,String action) {
		switch(action) {
		case "viewOrdersByUser":
		case "viewOrdersFilterByStatus":
			displayOrdersByUser(out,orders);
			break;
		}
	}
	public void displayOrdersByUser(PrintWriter out,ArrayList<Orders> orders){
		out.write(
				"<html><head><title>displayOrdersByUser</title></head><body>"
				+ "<table border=\"1\"><tr><th>Order Number</th>"
				+ "<th>Customer ID</th><th>Saleman ID</th><th>Ordered Date</th><th>Status</th>");
			for(Orders o:orders) {
				out.write("<tr><td>"+o.getOrder_id()+"</td><td>"+o.getCustomer_id()
				+"</td><td>"+o.getSalesman_id()+"</td><td>"+o.getOrder_date()
				+"</td><td>"+o.getStatus()+"</td></tr>");
			}
			out.write("</table></body></html>");	
		
	}

}
