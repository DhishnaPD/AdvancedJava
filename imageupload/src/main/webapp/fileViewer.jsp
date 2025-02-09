<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.sql.*, java.util.*, java.io.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Image Viewer</title>
</head>
<body>
    <h1>Uploaded Images</h1>
    <%
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");  // Use the new driver class for MySQL 8.x
            connection = DriverManager.getConnection("jdbc:mysql://localhost/java1", "root", "root");

            // Prepare the SQL statement to select all image paths
            preparedStatement = connection.prepareStatement("SELECT * FROM images");
            resultSet = preparedStatement.executeQuery();

            // Loop through the result set and display images
            while (resultSet.next()) {
                String filePath = resultSet.getString("image");
                // Assuming the 'image' column contains the relative file path
                
                // Ensure the correct path to the image file
                out.println("<img src='uploads/" + filePath + "' alt='Image' style='max-width: 300px;'><br/>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Log the error message for better debugging
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            // Ensure all resources are closed
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                out.println("<p>Error closing resources: " + e.getMessage() + "</p>");
            }
        }
    %>
</body>
</html>
