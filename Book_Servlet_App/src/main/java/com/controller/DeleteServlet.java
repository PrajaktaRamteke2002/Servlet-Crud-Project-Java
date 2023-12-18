package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.utility.DBUtility;


//@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO dao=new BookDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String did=request.getParameter("did");
		
		int id1=Integer.parseInt(did);
		
		try {
			
			int i = dao.DeleteBookByID(id1);

			if (i > 0) {
				out.print("<b> RECORD DELETED SUCCESS !!!!<b>");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
