<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.User" %>
<%@page import="java.util.*" %>  
<%@page import="com.model.UserModel" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-color:lightgrey;">
<center>
<center><h1> <font color="green" >Registration Table Information </font></h1></center>
<pre></pre>
<%List<User> users = UserModel.getUser(); %>
<table border = "1">

<tr>
	<td><b>ID</b></td>
	<td><b>First Name</b></td>
	<td><b>Last Name</b></td>
	<td><b>Email</b></td>
	
	<td><b>User Name</b></td>
	<td><b>Password</b></td>
	<td><b>Gender</b></td>
	<td><b>City</b></td>	
	<td>Country</td>
	<td><b>Edit</b></td>
	<td><b>Delete</b></td>
</tr>
<%for(User u:users){%>
<tr>
	<td><%=u.getId() %></td>
	<td><%=u.getFirstname() %></td>
	<td><%=u.getLastname() %></td>
	<td><%=u.getEmail() %></td>
	
	<td><%=u.getUsername() %></td>
	<td><%=u.getPassword() %></td>
	<td><%=u.getGender() %></td>
	<td><%=u.getCity() %></td>
	<td><%=u.getCountry() %></td>
	<td><form action="UserServlet" method="get">
	<input type="hidden" name="userid" value="<%=u.getId()%>">
	
	<input type="submit" name="submit" value="Edit">
		</form></td>
	<td><form action="UserServlet" method="get">
	<input type="hidden" name="userid" value="<%=u.getId()%>" />
	<input type="submit" name="submit" value="Delete" />
	
	</form></td>
	
</tr>
<%} %>


</table>

</center>
<pre></pre>
<center>
  <a href="index.jsp">Return</a>
</center>
<%-- <input type="submit" name="submit" value="Return" />--%>
</body>
</html>



