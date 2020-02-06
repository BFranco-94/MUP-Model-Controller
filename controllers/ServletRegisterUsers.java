package org.MyUniversityProject.controllers;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.MyUniversityProject.model.InsertQuery;

/**
 * Servlet implementation class ServletRegisterUsers
 */
@WebServlet(
		description = "Introduce dates to DB with information about users log", 
		urlPatterns = { 
				"/ServletRegisterUsers", 
				"/register-user"
		})
public class ServletRegisterUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegisterUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	

   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
    	String userName=request.getParameter("userName");
    	String email=request.getParameter("email");
    	String password=request.getParameter("password");
    	boolean isCheckedTerms=Boolean.parseBoolean(request.getParameter("checkTterms"));
    	InsertQuery iq= new InsertQuery();
    	String resCheckbox = (isCheckedTerms)? "1":"0";
		Object []values={
				userName, 
				email, 
				password,
				resCheckbox
		};
		
		iq.setValues(values);
		boolean answer = false;
		String noteSuccess="Register Successfull!";
		String noteError="Try with other Email or UserName";
		String Message=""; 
		try {
			boolean answer2 = iq.QueryPrepare(userName, email, password, resCheckbox);
			System.out.println(answer2);
			Message = (answer2)? noteSuccess: noteError;
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(Message); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String jSon=
				"{ "
					+"\"dataRegister\":{"
		    			+ "\"userName\":\""+userName+"\","
		    			+ "\"email\":\""+email+"\","
		    			+ "\"password\":\""+password+"\","
		    			+ "\"isCheckedTerms\":"+isCheckedTerms
					+ "}"
				+ "}";	
		
    }

}
