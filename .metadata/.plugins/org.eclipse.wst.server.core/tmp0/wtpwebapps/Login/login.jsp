<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*, java.util.*, java.io.*, javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login System</title>
</head>
<body>

<form action="login.jsp" method="post">
    <label for="username">UserName</label>
    <input type="text" name="username" id="username">
    <label for="password">Password</label>
    <input type="password" name="password" id="password">
    <input type="submit" value="Login">
</form>

<%
    if (request.getParameter("username") != null && !request.getParameter("username").isEmpty() &&
        request.getParameter("password") != null && !request.getParameter("password").isEmpty()) {

        // Database Connection and Login Logic
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/java1", "root", "root");
            preparedStatement = connection.prepareStatement("SELECT * FROM login_table WHERE username=? and password=?");
            preparedStatement.setString(1, request.getParameter("username"));
            preparedStatement.setString(2, request.getParameter("password"));
            ResultSet resultSet = preparedStatement.executeQuery();

            boolean loginSuccess = false;
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(request.getParameter("username")) &&
                    resultSet.getString("password").equals(request.getParameter("password"))) {
                    loginSuccess = true;
                    break;
                }
            }

            if (loginSuccess) {
                // Set the userid attribute in the session if successful login
                session.setAttribute("userid", request.getParameter("username"));

                // Consider removing the unnecessary check (optional)
                // if (session.getAttribute("userid") == null || session.getAttribute("userid").equals("")) {
                //     response.sendRedirect("index.jsp"); // Optional redirect
                // } else {
                    out.println("<center><h1>Welcome!! " + session.getAttribute("userid") + "</h1></center>");
                // }
            } else {
                out.println("<b>Unauthorised Login Attempt</b>");
            }

        } catch (SQLException e) {
            // Handle SQLException more gracefully (e.g., log the error)
            e.printStackTrace(); // Or log the error using a logging library
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
%>
<form action="logoutUser.jsp" method="POST">
    <button type="submit">Logout</button>
</form>
</body>
</body>
</html>