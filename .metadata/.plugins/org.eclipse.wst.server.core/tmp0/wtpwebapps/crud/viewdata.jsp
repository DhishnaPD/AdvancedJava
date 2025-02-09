<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*, java.util.*, java.io.*, javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
<th>Delete</th>
<th>Update</th>
</tr>
<%
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
try {
    // Load MySQL JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    
    // Establish the connection to the database
    connection = DriverManager.getConnection("jdbc:mysql://localhost/java1", "root", "root");
    
    // Create statement and execute query
    statement = connection.createStatement();
    resultSet = statement.executeQuery("SELECT * FROM student");

    // Output the results in a table
    while (resultSet.next()) {
        out.println("<tr>");
        out.println("<td>");
        out.println(resultSet.getString("firstName"));
        out.println("</td>");
        out.println("<td>");
        out.println(resultSet.getString("lastName"));
        out.println("</td>");
        out.println("<td>");
        out.println(resultSet.getInt("age"));
        out.println("</td>");
        out.println("<td>");
        out.println("<a href=\"delete.jsp?id=" + URLEncoder.encode(String.valueOf(resultSet.getInt("id")), "UTF-8") + "\">Delete</a>");
        out.println("</td>");
        out.println("<td>");
        out.println("<a href=\"updateform.jsp?id=" + URLEncoder.encode(String.valueOf(resultSet.getInt("id")), "UTF-8") + "\">Update</a>");
        out.println("</td>");
        out.println("</tr>");
    }
} catch (SQLException e) {
    // Handle SQLException
    out.println("SQLException: " + e.getMessage());
} catch (ClassNotFoundException e) {
    // Handle ClassNotFoundException
    out.println("ClassNotFoundException: " + e.getMessage());
} finally {
    // Close resources in the finally block to ensure they are closed even if an exception occurs
    try {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    } catch (SQLException e) {
        out.println("Error while closing resources: " + e.getMessage());
    }
}
%>

</table>
<c:if test="${not empty param.update }">
<script>window.alert("Record updated");</script>
</c:if>
<c:if test="${not empty param.updateError }">
<script>window.alert("Cannot be updated");</script>
</c:if>
</body>
</html>