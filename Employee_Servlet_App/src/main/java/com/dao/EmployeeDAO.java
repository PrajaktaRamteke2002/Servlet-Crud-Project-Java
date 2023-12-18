package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.mysql.cj.protocol.Resultset;
import com.utility.DBUtility;

public class EmployeeDAO {

	//Insert data
	
	public int InsertEmployeeData(Employee employee) throws SQLException {
		
		Connection con=DBUtility.getDBConnection();
		String sql="insert into employees values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, employee.getId());
		ps.setString(2, employee.getName());
		ps.setDouble(3, employee.getSalary());
		
		return ps.executeUpdate();
		
		
	}
	//Delete employee data
	
	public int DeleteEmployeeByID(int id1) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="Delete from employees where emp_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, id1);
		return ps.executeUpdate();
		
		
		
		
	}
	
	//Update Employee data
	
	public int UpdateEmployeeData(Employee employee) throws SQLException
	{
		Connection con=DBUtility.getDBConnection();
		String sql="Update employees set emp_name=?,emp_salary=? where emp_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, employee.getName());
		ps.setDouble(2, employee.getSalary());
		ps.setInt(3, employee.getId());
		
		return ps.executeUpdate();
		
	}
	
	//Display Employee data
	
	public List<Employee> displayAllEmployee() throws SQLException{
		
		List<Employee> list=new ArrayList<Employee>();
		
		Connection con=DBUtility.getDBConnection();
		String sql="Select * from employees";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Employee employee=new Employee();
			
			employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setSalary(rs.getDouble(3));
			
			list.add(employee);
		}
		return list;
	}
	
	
}
