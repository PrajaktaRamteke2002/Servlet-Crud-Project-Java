package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;


//l=@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmployeeDAO dao=new EmployeeDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("did");
		
		int id1=Integer.parseInt(id);
		
		
		try {
			int i=dao.DeleteEmployeeByID(id1);
			if(i>0) {
				out.print("Employee Data Deleted successfully");
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

}
