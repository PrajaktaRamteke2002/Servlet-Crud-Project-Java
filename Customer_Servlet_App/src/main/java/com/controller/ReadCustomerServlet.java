package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDAO;
import com.model.Customer;



//@WebServlet("/ReadCustomerServlet")
public class ReadCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	CustomerDAO dao=new CustomerDAO();
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	try {
		List<Customer> list=dao.displayAllCustomer();
		Iterator<Customer> itr=list.iterator();
		
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> ADDRESS </th>");
		out.print("</tr>");
		
		while(itr.hasNext()) {
			Customer emp=itr.next();
			out.print("<tr>");
			out.print("<td>"+ emp.getId() +"</td>");
			out.print("<td>"+ emp.getName() +"</td>");
			out.print("<td>"+ emp.getAddress() +"</td>");
		}
		out.print("</table>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
	
	}

}
