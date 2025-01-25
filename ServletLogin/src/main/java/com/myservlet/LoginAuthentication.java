package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
* Servlet implementation class LoginAuthentication
*/
@WebServlet("/LoginAuthentication")
public class LoginAuthentication extends HttpServlet {
private static final long serialVersionUID = 1L;
 
 /**
 * @see HttpServlet#HttpServlet()
 */
 public LoginAuthentication() {
 super();
 // TODO Auto-generated constructor stub
 }
 /**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
 ServletException, IOException {
 // TODO Auto-generated method stub
 }
 /**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
 ServletException, IOException {
 // TODO Auto-generated method stub
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 String userName= request.getParameter("username");
 String password = request.getParameter("password");
 HttpSession session = request.getSession();
 ResultSet resultSet = null;
 Connection connection = null;
 PreparedStatement preparedStatement = null;
 if(userName != null && !userName.isEmpty() && !password.isEmpty() &&  password!=null) {
 try {
  Class.forName("com.mysql.jdbc.Driver");
  connection = DriverManager.getConnection("jdbc:mysql://localhost/java1","root","root");
 preparedStatement = connection.prepareStatement("SELECT *  FROM login_table WHERE username=?");
 preparedStatement.setString(1, userName);
 resultSet = preparedStatement.executeQuery();
 while(resultSet.next()) {
 if(resultSet.getString("password").equals(password)) {
 session.setAttribute("userName", userName);
 }
 }
 }catch (Exception e) {
 // TODO: handle exception
 System.out.println(e);
 }finally {
 if(connection != null) {
 try {
 connection.close();
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }
 if(preparedStatement != null) {
 try {
	 preparedStatement.close();
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }
 if(resultSet != null) {
 try {
 resultSet.close();
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }
 }}else {
	 out.println("Username and password cannot be empty");
 }
 if(session.getAttribute("userName") != null && 
 !session.getAttribute("userName").equals("")) {
 out.println("<b>Welcome "+userName+"</b>");
 out.println("<a href=\"Logout\">Logout</a>");
 }else {
	 out.println("<b>Sorry wrong password or username</b>");
 }
 out.close();
 }
 }