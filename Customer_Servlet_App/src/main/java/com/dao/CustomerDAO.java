package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;

import com.mysql.cj.protocol.Resultset;
import com.utility.DBUtility;

public class CustomerDAO {

	//insert data
	
	public int InsertCustomerData(Customer customer) throws SQLException {
		
		Connection con=DBUtility.getDBConnection();
		String sql ="insert into customer values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, customer.getId());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getAddress());
		
		return ps.executeUpdate();
	}
	//Delete data
	public int DeleteDataByID(int id1) throws SQLException {
		
		Connection con=DBUtility.getDBConnection();
		String sql="delete from customer where cust_id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1,id1);
		
		return ps.executeUpdate();
		
	}
	//Update data
	public int UpdateCustomerData(Customer customer) throws SQLException
	{
		Connection con=DBUtility.getDBConnection();
		String sql="update customer set cust_name=?,cust_address=? where cust_id=?";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, customer.getName());
		ps.setString(2, customer.getAddress());
		ps.setInt(3,customer.getId());
		
		
		return ps.executeUpdate();
		
	}
	//read data
	
	public List<Customer> displayAllCustomer() throws SQLException{
		
		List<Customer> list=new ArrayList<Customer>();
		Connection con=DBUtility.getDBConnection();
		String sql= "select * from customer";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			Customer customer=new Customer();
			customer.setId(rs.getInt(1));
			customer.setName(rs.getString(2));
			customer.setAddress(rs.getString(3));
			
			list.add(customer);
		}
		
		return list;
	}

}
