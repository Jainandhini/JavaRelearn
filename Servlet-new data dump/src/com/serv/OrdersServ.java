package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;
import com.display.OrdersDisplay;
import com.pojo.Orders;

/**
 * Servlet implementation class Orders
 */
@WebServlet("/Orders")
public class OrdersServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrdersDAO ordersDAO;
	OrdersDisplay odisp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServ() {
        super();
        ordersDAO=new OrdersDAO();
        odisp=new OrdersDisplay();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("test1");
		String custID;
		ArrayList<Orders> ordersList;
		PrintWriter out=response.getWriter();
		String action=request.getParameter("orderAction");
		String[] status=request.getParameterValues("status");
		if(status!=null) {
			action="viewOrdersFilterByStatus";
		}
		//System.out.println("test2");
		switch(action) {
		case "viewOrdersByUser":
			 custID=request.getParameter("cust_id");
			 ordersList=ordersDAO.viewOrdersByUser(custID);
			odisp.displayOrders(out,ordersList,action);
			break;
		case "viewOrdersFilterByStatus":
			 custID=request.getParameter("cust_id");
			 ordersList=ordersDAO.viewOrdersFilterByStatus(custID,status);
			 odisp.displayOrders(out,ordersList,action);
			 break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
