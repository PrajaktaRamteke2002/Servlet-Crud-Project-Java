package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDAO;
import com.model.Customer;

//@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDAO dao=new CustomerDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("uid");
		String name=request.getParameter("uname");
		String address=request.getParameter("uaddress");
		
		int id1=Integer.parseInt(id);
		
		Customer customer =new Customer(id1,name,address);
		
		try {
			int i=dao.UpdateCustomerData(customer);
			if(i>0)
			{
				out.print("customer data updated successfully!!");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

}
