<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.User" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>
			Insert title here
		</title>
	</head>
	<body>
		<form action="UserServlet" method="get">
			<h3>Your history</h3>
	 
			<table>
				<tr>
					<td>
						<input type="text" name="search" />
					</td>
					<td>
						<input type="submit" name="submit" value="Search" maxlength="20" />
					</td>
				</tr>
			</table>
			<%Object checkN = request.getAttribute("submit"); %>
			<%if(checkN != null){ %>
				<%List<User> historyList = (ArrayList)request.getAttribute("HistoryList"); %>
				<table border="1">
					<tr>
						<td colspan="2">FirstName </td>
						<td colspan="2">LastName </td>
						<td colspan="2">Email </td>
						<td colspan="2">Gender </td>
						<td colspan="2">City </td>
						<td colspan="2">Origin </td>
						<td colspan="2">Destination </td>
						<td colspan="2">UserName </td>
					</tr>
					<%for(User u : historyList){ %>
						<tr>
							<td colspan="2"><%=u.getFirstname() %></td>
							<td colspan="2"><%=u.getLastname() %></td>
							<td colspan="2"><%=u.getEmail() %></td>
							<td colspan="2"><%=u.getGender() %></td>
							<td colspan="2"><%=u.getCity() %></td>
							<td colspan="2"><%=u.getOrigin() %></td>
							<td colspan="2"><%=u.getDestination() %></td>
							<td colspan="2"><%=u.getUsername() %></td>
						</tr>
					<%} %>
				</table>
			<%} %>
		</form>
	</body>
</html>