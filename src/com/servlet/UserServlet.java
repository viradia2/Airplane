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
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.model.UserModel;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserModel callMethod = new UserModel();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit=request.getParameter("submit");
		String checkN = checkingnull(submit);
		request.setAttribute("submit", checkN);
		
		if(submit.equalsIgnoreCase("Make Reservation")){
			User signupUser = getUserFromPage(request);
			try {
				callMethod.addUser(signupUser);
				request = setParameter(request);
				forwardPage("SummaryPage.jsp",request,response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Search")){
			String uN = request.getParameter("search");
			System.out.println(uN);
			try {
				List<User> historyList = callMethod.findHistory(uN);
				System.out.println(historyList);
				request.setAttribute("HistoryList", historyList);
				forwardPage("history.jsp", request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Book Reservation")){
			String username = request.getParameter("existusername");
			try {
				request = setPForExistUsername(username,request);
				forwardPage("index.jsp", request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Create Username")){
			String username1 = request.getParameter("newusername");
			
			try {
				if(username1.matches("^[a-zA-Z]+$")){
					request = setPForcreateUsername(username1, request);
					forwardPage("index.jsp", request, response);
				}else{
					String error="*Username only contains letters";
					request.setAttribute("error", error);
					forwardPage("LogIn.jsp", request, response);
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(submit.equalsIgnoreCase("Create User")){
			User uDetails = getUserFromPage(request);
			try {
				callMethod.createUser(uDetails);
				request = setParameter(request);
				forwardPage("index.jsp", request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private String checkingnull(String submit) {
		if(submit != null){
			return submit;
		}
		return null;
	}

	private HttpServletRequest setPForExistUsername(String username, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String user = callMethod.findUsername(username);
		String uName = callMethod.getUName(username);
		request.setAttribute("username", uName);
		List<String> list1 = callMethod.dropdown();
		request.setAttribute("city", list1);
		return request;
	}

	private HttpServletRequest setPForcreateUsername(String username1, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String uName = callMethod.getUName(username1);
		request.setAttribute("username", uName);
		List<String> list1 = callMethod.dropdown();
		request.setAttribute("city", list1);
		return request;
	}

	private HttpServletRequest setParameter(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String uName = callMethod.getUserName();
		request.setAttribute("userName",uName);
		List<User> summary = callMethod.getSummary();
		request.setAttribute("summaryDetails", summary);
		List<String> list1 = callMethod.dropdown();
		request.setAttribute("city", list1);
		return request;
	}

	private void forwardPage(String string, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(string == "SummaryPage.jsp"){
			request.getRequestDispatcher("SummaryPage.jsp").forward(request, response);
		}
		else if(string == "index.jsp"){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(string == "history.jsp"){
			request.getRequestDispatcher("history.jsp").forward(request, response);
		}
		else if(string == "LogIn.jsp") {
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		}
	}

	private User getUserFromPage(HttpServletRequest request) {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String origin=request.getParameter("origin");
		String destination=request.getParameter("destination");
		HttpSession session = request.getSession();
		String uN = session.getAttribute("username").toString();
		
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setCity(city);
		user.setEmail(email);
		user.setGender(gender);
		user.setOrigin(origin);
		user.setDestination(destination);
		user.setUsername(uN);
		return user;
	}
}
