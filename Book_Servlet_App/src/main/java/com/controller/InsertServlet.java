package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.model.Book;



//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    BookDAO dao=new BookDAO();
		
		    response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String id =request.getParameter("id");
			String name=request.getParameter("bname");
			String price=request.getParameter("price");
			
			 int id1=Integer.parseInt(id);
			Double price1=Double.parseDouble(price);
			
			Book book=new Book(id1,name,price1);
			
			
			try {
				
				int i=dao.InsertBook(book);
				if(i>0)
				{
					out.print("data inserted successfully!!!");
				}else
				{
					out.print("data not inserted!!!");
				}
				
			}catch(Exception e)
			{
				System.out.println("exception occurs"+e);
			}
			
			
	}

}
