package com.serv;

import java.io.IOException;
import com.dao.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServ
 */
@WebServlet("/EmployeeWel")
public class EmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpDAO empConn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // Set response content type
		
		empConn=new EmpDAO();
	
		String eID=request.getParameter("emp_id");
		System.out.println(eID);
		String name=empConn.getSampleData(eID);
	      response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      if(name!=null)
	    	  out.println("<h1>" + "Welcome " +name+ "</h1>");
	      else
	    	  out.println("<h1>" + "Sorry, wrong Employee ID"+ "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
