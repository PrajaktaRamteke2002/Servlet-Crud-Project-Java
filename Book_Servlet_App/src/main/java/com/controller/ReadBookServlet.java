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

import com.dao.BookDAO;
import com.model.Book;


//@WebServlet("/ReadBookServlet")
public class ReadBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
	BookDAO dao=new BookDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			List<Book> list=dao.getAllBooks();
			Iterator<Book> itr= list.iterator();
			
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> ID </th>");
			out.print("<th> NAME </th>");
			out.print("<th> Marks </th>");
			out.print("</tr>");
			
			while(itr.hasNext()) {
				Book book1=itr.next();
				out.print("<tr>");
				out.print("<td>"+ book1.getId() +"</td>");
				out.print("<td>"+ book1.getName() +"</td>");
				out.print("<td>"+ book1.getPrice() +"</td>");
			}
			out.print("</table>");
		}catch(Exception e) 
		{
			System.out.println(e);
		}
		
	
	
	}

}
