<%@page import="com.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.UserModel" %>
<%@page import="com.bean.User" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body style="background-color:lightgrey;">
	
		<%Object uN = session.getAttribute("username"); %>
		<center>
			<h2>Summary Of Flight Details</h2>
		</center>
		
		You are signed in as  <%=uN %> <br>
		<% List<User> sDetails = (ArrayList<User>)request.getAttribute("summaryDetails"); %>
		Your Flight Details:<br>
		<table>
			<%for(User u:sDetails){ %>
				<tr>
					<td>Start : </td>
					<td><%=u.getOrigin()%></td>
				</tr>
				<tr>
					<td>Destination : </td>
					<td><%=u.getDestination() %></td>
				</tr>
				<tr>
					<td>FirstName : </td>
					<td><%=u.getFirstname() %></td>
				</tr>
				<tr>
					<td>LastName : </td>
					<td><%=u.getLastname() %></td>
				</tr>
				<tr>
					<td>City : </td>
					<td><%=u.getCity() %></td>
				</tr>
				<tr>
					<td>Gender </td>
					<td><%=u.getGender() %></td>
				</tr>
				<tr>
					<td>Email : </td>
					<td><%=u.getEmail() %></td>
				</tr>
			<%}%>
		</table>
	</body>
</html>