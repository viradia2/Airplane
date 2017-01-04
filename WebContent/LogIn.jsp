<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	div.block{
	    text-align: center;
	    vertical-align: middle;
	    height: 200px;
	    width: 400px;
	    position: fixed;
	    top: 50%;
	    left: 50%;
	    margin-top: -100px;
	    margin-left: -200px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserServlet" method="get">
<div class="block">
	<input type="text" name="username" placeholder="Enter Username" />
	<input type="submit" name="submit" value="Book Reservation" /><br>
	<h3> OR </h3> 
	<input type="text" name="username1" placeholder="Enter Username" />
	<input type="submit" name="submit" value="Create Username" />
</div>
</form>
</body>
</html>