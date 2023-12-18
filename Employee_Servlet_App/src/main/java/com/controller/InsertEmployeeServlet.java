package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;


//@WebServlet("/InsertEmployeeServlet")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO dao=new EmployeeDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("eid");
		String name=request.getParameter("ename");
		String salary=request.getParameter("esalary");
		
		int id1=Integer.parseInt(id);
		Double salary1=Double.parseDouble(salary);
		
		Employee employee=new Employee(id1,name,salary1);
	     
		try {
			
			int i= dao.InsertEmployeeData(employee);
			if(i>0)
			{
				out.print("Employee data inserted Successfully!!!!");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
