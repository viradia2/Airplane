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
			<table>
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
				</tr>
				<tr>
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
				<tr>
					<td>
						<input type="submit" name="submit" value="Confirm" maxlength="20">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>