package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.mysql.cj.protocol.Resultset;
import com.utility.DBUtility;

public class BookDAO{

//insert data
		public int InsertBook(Book book)throws SQLException {
			
			Connection con=DBUtility.getDBConnection();
			
			String sql="insert into book values(?,?,?)";
			
		   PreparedStatement ps=con.prepareStatement(sql);
		   
			ps.setInt(1,book.getId());
			ps.setString(2, book.getName());
			ps.setDouble(3,book.getPrice());
			
			return ps.executeUpdate();
			
		
	}
		
		//delete data
		
		public int DeleteBookByID(int id1) throws SQLException {
			
			Connection con=DBUtility.getDBConnection();
			String sql="delete from book where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, id1);
			
			return ps.executeUpdate();
			
			
		}
		
		//update data
		
		public int UpdateBookByID(Book book) throws SQLException {
			
			Connection con= DBUtility.getDBConnection();
			String sql="update book set name=?,price=? where id=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, book.getName());
			ps.setDouble(2, book.getPrice());
			ps.setInt(3, book.getId());
			
			return ps.executeUpdate();
		}
		
		//Display data
		
		public List<Book> getAllBooks() throws SQLException{
			
			List<Book> list=new ArrayList<Book>();
			
			Connection con=DBUtility.getDBConnection();
			
			String sql="Select * from book";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Book book=new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setPrice(rs.getDouble(3));
				
				list.add(book);
			}
			return list;
			
		}
		
		
		

}











