package com.servlet;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.model.UserModel;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit=request.getParameter("submit");
		UserModel um = new UserModel();
		if(submit.equalsIgnoreCase("Make Reservation")){
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String email=request.getParameter("email");
			String gender=request.getParameter("gender");
			String city=request.getParameter("city");
			String origin=request.getParameter("origin");
			String destination=request.getParameter("destination");
			
			User u = new User();
			u.setFirstname(firstname);
			u.setLastname(lastname);
			u.setCity(city);
			u.setEmail(email);
			u.setGender(gender);
			u.setOrigin(origin);
			u.setDestination(destination);
			
			try {
				um.addUser(u);
				String uName = um.getUserName();
				request.setAttribute("userName",uName);
				List<User> summary = um.getSummary();
				request.setAttribute("summaryDetails", summary);
				request.getRequestDispatcher("SummaryPage.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Book Reservation")){
			String username = request.getParameter("username");
			try {
				String user = um.findUsername(username);
				String uName = um.getUName(username);
				request.setAttribute("username", uName);
				List<String> list1 = um.dropdown();
				request.setAttribute("city", list1);
				boolean done = username.equals(user);
				if(done == true)
					request.getRequestDispatcher("index.jsp").forward(request, response);
				else
					response.sendRedirect("LogIn.jsp");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Create Username")){
			String username1 = request.getParameter("username1");
			System.out.println(username1);
			try {
				um.addUsername(username1);
				System.out.println(username1);
//				String user = um.findUsername(username1);
				String uName = um.getUName(username1);
				request.setAttribute("username", uName);
				List<String> list1 = um.dropdown();
				request.setAttribute("city", list1);
//				boolean done = username1.equals(user);
//				if(done == true)
					request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Create User")){
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String email=request.getParameter("email");
			String username=request.getParameter("username");
			
			User u1 = new User();
			u1.setFirstname(firstname);
			u1.setEmail(email);
			u1.setLastname(lastname);
			u1.setUsername(username);
			
			try {
				um.createUser(u1);
				String uName = um.getUserName();
				request.setAttribute("username", uName);
				List<String> list1 = um.dropdown();
				request.setAttribute("city", list1);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
