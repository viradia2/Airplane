package com.model;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import com.bean.User;
import com.db.DBConnection;
import com.servlet.*;

public class UserModel {

	 public void addUser(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String sql="insert into user(firstname,lastname,email,gender,city,origin,destination) values('"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getEmail()+"','"+user.getGender()+"','"+user.getCity()+"','"+user.getOrigin()+"','"+user.getDestination()+"')";
		stmt.executeUpdate(sql);
	}
	 public String getUserName() throws ClassNotFoundException, SQLException{
		 Connection con=DBConnection.getConnection();
		 Statement stmt=con.createStatement();
		 String sql="select username from createuser where id =(select max(id) from createuser)";
		 ResultSet rs=stmt.executeQuery(sql);
		 rs.next();
		 String username = rs.getString(1);
		 return username;
	 }
	 
	 public List<User> getSummary() throws ClassNotFoundException, SQLException{
		 Connection con = DBConnection.getConnection();
		 Statement stmt = con.createStatement();
		 String sql = "select * from user where Number =(select max(Number) from user)";
		 
		 List<User> summary = new ArrayList<User>();
		 ResultSet rs = stmt.executeQuery(sql);
		 while(rs.next()){
			 int id = rs.getInt(1);
			 String firstname = rs.getString(2);
			 String lastname = rs.getString(3);
			 String email = rs.getString(4);
			 String city = rs.getString(6);
			 String gender = rs.getString(5);
			 String origin = rs.getString(7);
			 String destination = rs.getString(8);
			 
			 User user = new User();
			 user.setId(id);
			 user.setFirstname(firstname);
			 user.setLastname(lastname);
			 user.setEmail(email);			
			 user.setGender(gender);
			 user.setCity(city);
			 user.setOrigin(origin);
			 user.setDestination(destination);
			 summary.add(user);
		 }
		 return summary;
	 }
	
	public List<String> dropdown () throws ClassNotFoundException, SQLException {
			Connection con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			String sql="select * from city";
			List<String> list = new ArrayList<>(); 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String country = rs.getString(2);
				list.add(country);
			}
			return list;
		}

	public void createUser(User u1) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql = "insert into createuser(username,firstname,lastname,email) values('"+u1.getUsername()+"','"+u1.getFirstname()+"','"+u1.getLastname()+"','"+u1.getEmail()+"') ";
		stmt.executeUpdate(sql);
	}
	
	public String findUsername(String username) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Connection con=DBConnection.getConnection();
		 Statement stmt=con.createStatement();
		 String sql="select * from UserName where username = '"+username+"'";
		 ResultSet rs=stmt.executeQuery(sql);
		 String username1 = null;
		 while(rs.next()){
			 username1 = rs.getString(2);
		 }
		 return username1;
	}
	
	public void addUsername(String username1) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql = "insert into UserName(username) values('"+username1+"') ";
		System.out.println(sql);
		stmt.executeUpdate(sql);
	}
	
	public String getUName(String username) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Connection con=DBConnection.getConnection();
		 Statement stmt=con.createStatement();
		 String sql="select * from UserName where username = '"+username+"'";
		 ResultSet rs=stmt.executeQuery(sql);
		 String username1 = null;
		 while(rs.next()){
			 username1 = rs.getString(2);
		 }
		 return username1;
	}
}
