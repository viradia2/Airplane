<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h3>
		Create User Account
	</h3>
	<table>
		<tr>
			<td>User Name </td>
		    <td>
		    	<input type="text" name="username">
		    </td>
		</tr>
		<tr>
			<td>First Name  </td>
			<td>
				<input type="text" name="firstname" /><br>
			</td>
		</tr>	
		<tr>
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
		</tr>
	</table>
	<input type="submit" name="submit" value="Create User" />
	</form>
</body>
</html>