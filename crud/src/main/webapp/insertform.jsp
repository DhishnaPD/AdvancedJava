<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*, java.util.*, java.io.*, javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insert.jsp" method="POST">
<label for="fname">FirstName</label>
<input type="text" id="fname" name="fname">
<label for="lname">LastName</label>
<input type="text" id="lname" name="lname">
<label for="age">Age</label>
<input type="number" name="age" id="age">
<button type="submit">Ok</button>
</form>
<c:if test="${not empty param.success}">
 <p>Data inserted successfully!</p>
 </c:if>
</body>
</html>