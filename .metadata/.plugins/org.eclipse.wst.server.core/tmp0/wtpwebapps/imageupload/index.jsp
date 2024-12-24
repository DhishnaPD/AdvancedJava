<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.servlet.*"%>   
 <%@page import="java.sql.*, java.util.*, java.io.*"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to the Image Upload and Viewer</h1>

    <!-- Buttons to navigate to upload and view pages -->
    <button class="upload-btn">
        <a href="imageUpload.jsp">Upload Image</a>
    </button>
    
    <button class="view-btn">
        <a href="fileViewer.jsp">View Images</a>
    </button>
</body>
</html>