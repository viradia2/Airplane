<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bean.User" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.model.UserModel" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-color:lightgrey;">
<center> <h1><font color="green">Registration Form </font></h1></center>
<%User u = (User)request.getAttribute("tops"); %>
<center>

<form action="UserServlet" method="get">
<input type="hidden" name="userid" value="<%=u.getId()%>" />
<table>

<tr><td>First Name </td><td><input type="text" name="firstname" value="<%=u.getFirstname()%>" /><br></td></tr>
<tr><td>Last Name  </td><td><input type="text" name="lastname" value="<%=u.getLastname()%>" /><br></td></tr>
<tr><td>Email      </td><td><input type="text" name="email" value="<%=u.getEmail()%>" /><br></td></tr>
<tr><td>User Name  </td><td><input type="text" name="username" value="<%=u.getUsername()%>" /><br></td></tr>
<tr><td>Password   </td><td><input type="password" name="password" value="<%=u.getPassword()%>" /><br></td></tr>
<tr><td>Gender      </td><td><select name="gender">
			<option label="Choose"></option>
					  <option value="male">Male</option>
					   <option value="female">Female</option></select></td></tr><br>
<tr><td>City</td><td>



     <%List<String> list = UserModel.drop(); %>
     <select name="city">
      <option label="Choose"></option>
        <% for (String temp : list) {
			System.out.println(temp);
		 %>
		 <option><%=temp %></option>
            
        <% } %>
        </select>
<br></td></tr>
<tr><td>Country</td><td>



     <%List<String> list1 = UserModel.dropdown(); %>
     <select name="country">
      <option label="Choose"></option>
        <% for (String temp : list1) {
			System.out.println(temp);
		 %>
		 <option><%=temp %></option>
            
        <% } %>
        </select>
<br></td></tr>
				   
</table>

<input type="submit" name="submit" value="Update" />
</form>



</center>
</body>
</html>