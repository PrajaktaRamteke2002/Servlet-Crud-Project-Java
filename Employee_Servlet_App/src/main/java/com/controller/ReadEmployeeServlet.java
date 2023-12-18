package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;


//@WebServlet("/ReadEmployeeServlet")
public class ReadEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO dao=new EmployeeDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		List<Employee> list=dao.displayAllEmployee();
		Iterator<Employee> itr=list.iterator();
		
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> SALARY </th>");
		out.print("</tr>");
		
		while(itr.hasNext()) {
			Employee emp=itr.next();
			out.print("<tr>");
			out.print("<td>"+ emp.getId() +"</td>");
			out.print("<td>"+ emp.getName() +"</td>");
			out.print("<td>"+ emp.getSalary() +"</td>");
		}
		out.print("</table>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

}
