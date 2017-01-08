<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.Connection" %>
<%@ page import="com.model.UserModel" %>
<%@page import="com.bean.User" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
	<link href="index.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		Ticket Reservation
	</title>
</head>
<body style="background-color:white;">
	<%Object userName = request.getAttribute("username");%>
	<%session.setAttribute("username", userName); %>
	<header>
		<img alt="Student Universe" src="C:\Users\vvviradia\Desktop\images.jpg" style="width:50px;height:50px;">
		<font color="green" size="10">
			StudentUniverse 
		</font>
	</header>		
	
	<div class="Bright">
		You are signed in as <%=userName %> 
	</div>
	
	<ul class="menu">
	  <li>
	  	<a href="#flight">Flight</a>
	  </li>
	  <li>
	  	<a href="history.jsp" name="History" type="submit">History</a>
	  </li>
	  <li>
	  	<a href="#contact">Tour</a>
	  </li>
	</ul>
	
	<form action="UserServlet" method="get">
		<table>
			<tr>
				<td>
					<input type="radio" value="One-Way" name="Way" />
					<label>One-Way</label>
				</td>
				<td>
					<input type="radio" value="Round-Trip" name="Way" />
					<label>Round-Trip</label>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>From : </td>
				<td>
					<%List<String> cityList = (ArrayList)request.getAttribute("city"); %>
				    <select name="origin">
					     <option label="Choose"></option>
					     <% for (String temp : cityList) {%>
						 <option><%=temp %></option>
					     <% } %>
				    </select>
				</td>
				<td>To : </td>
				<td>
					<select name="destination">
				        <option label="Choose"></option>
				        <% for (String temp : cityList) { %>
						<option><%=temp %></option>
				        <% } %>
					</select><br>
				</td>
			</tr>
		</table>
		<h3>
			Personal Information
		</h3>
	
		<table cellspacing="10">
			<tr>
				<td>First Name  </td>
				<td>
					<input type="text" name="firstname" /><br>
				</td>		
				<td>Last Name   </td>
				<td>
					<input type="text" name="lastname" /><br>
				</td>
			</tr>
			<tr>
				<td>Email       </td>
				<td>
					<input type="text" name="email" /><br>
				</td>
				<td>City        </td>
				<td>
					<input type="text" name="city" /><br>
				</td>
			</tr>
			<tr>
				<td>Gender      </td>
				<td>
					<select name="gender">
						<option label="Choose"></option>
					    <option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Make Reservation" maxlength="20" />
	</form>
</body>
</html>

