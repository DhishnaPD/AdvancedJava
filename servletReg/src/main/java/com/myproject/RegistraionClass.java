package com.myproject;

import java.io.IOException; 
import java.io.PrintWriter; 

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import java.sql.*; 
 
/**  * Servlet implementation class RegistrationClass  */
@WebServlet("/RegistrationClass") 
public class RegistraionClass extends HttpServlet {
	private static final long serialVersionUID = 1L;            
	/**      * @see HttpServlet#HttpServlet()      */
	public RegistraionClass() {
		 super();}         // TODO Auto-generated constructor stub 
		 /**   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)   */
		 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 // TODO Auto-generated method stub 
			 response.setContentType("text/html"); //  
			 PrintWriter out = response.getWriter(); //  
			 out.println("<html><body>Hello</body></html>");  
			 }  
		 /**   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)   */
		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
			 // TODO Auto-generated method stub   
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 String name = request.getParameter("name");
			 String password = request.getParameter("password");
			 String country = request.getParameter("country");
			 String email = request.getParameter("email");
			 Connection connection = null;
			 int affectedRows=0;
		 }
	}

