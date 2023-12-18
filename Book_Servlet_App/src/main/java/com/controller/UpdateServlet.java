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


//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookDAO dao=new BookDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("uid");
		String name=request.getParameter("uname");
		String price=request.getParameter("uprice");
		
		int id1=Integer.parseInt(id);
		Double price1=Double.parseDouble(price);
		
		Book book=new Book(id1,name,price1);
		
		//database code
		
		try {
			
			int i=dao.UpdateBookByID(book);
			if(i>0)
			{
				out.print("record updated successfully!!!!");
			}
		}catch(Exception e)
		{
			System.out.println("exception "+e);
		}
	
	}

}
