package com.welcome;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
* Servlet implementation class Logout
*/
@WebServlet("/Logout")
public class Logout extends HttpServlet {
private static final long serialVersionUID = 1L;
/**
 * @see HttpServlet#HttpServlet()
 */
 public Logout() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
// TODO Auto-generated method stub
response.setContentType("text/html");
PrintWriter out= response.getWriter();
HttpSession session = request.getSession();
session.invalidate();
out.println("<b>Logout successfull</b>");
out.println("<a href=\"index.html\">Home</a>");
out.close();
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
// TODO Auto-generated method stub
}
}