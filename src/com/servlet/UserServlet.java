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
		UserModel callMethod = new UserModel();
		if(submit.equalsIgnoreCase("Make Reservation")){
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String email=request.getParameter("email");
			String gender=request.getParameter("gender");
			String city=request.getParameter("city");
			String origin=request.getParameter("origin");
			String destination=request.getParameter("destination");
			
			User uDetails = new User();
			uDetails.setFirstname(firstname);
			uDetails.setLastname(lastname);
			uDetails.setCity(city);
			uDetails.setEmail(email);
			uDetails.setGender(gender);
			uDetails.setOrigin(origin);
			uDetails.setDestination(destination);
			
			try {
				callMethod.addUser(uDetails);
				String uName = callMethod.getUserName();
				request.setAttribute("userName",uName);
				List<User> summary = callMethod.getSummary();
				request.setAttribute("summaryDetails", summary);
				request.getRequestDispatcher("SummaryPage.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Book Reservation")){
			String username = request.getParameter("existusername");
			try {
				String user = callMethod.findUsername(username);
				String uName = callMethod.getUName(username);
				request.setAttribute("username", uName);
				List<String> list1 = callMethod.dropdown();
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
			String username1 = request.getParameter("newusername");
			try {
				callMethod.addUsername(username1);
				String uName = callMethod.getUName(username1);
				request.setAttribute("username", uName);
				List<String> list1 = callMethod.dropdown();
				request.setAttribute("city", list1);
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
			
			User uDetails = new User();
			uDetails.setFirstname(firstname);
			uDetails.setEmail(email);
			uDetails.setLastname(lastname);
			uDetails.setUsername(username);
			
			try {
				callMethod.createUser(uDetails);
				String uName = callMethod.getUserName();
				request.setAttribute("username", uName);
				List<String> list1 = callMethod.dropdown();
				request.setAttribute("city", list1);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
