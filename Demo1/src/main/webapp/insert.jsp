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
<%
String fname = request.getParameter("fname");
 String lname = request.getParameter("lname");
 String age = request.getParameter("age");
 if (fname != null && !fname.isEmpty() && lname != null && !lname.isEmpty() && age
!= null && !age.isEmpty()) {
System.out.println("Test");
Connection connection=null;
PreparedStatement preparedStatement = null;
int rowsAffected=0;
String url="jdbc:mysql://localhost/java1";
String driver="com.mysql.jdbc.Driver";
String userName = "root";
String password="root";
try{
Class.forName(driver);
connection = DriverManager.getConnection(url, userName,password);
connection.setAutoCommit(true);
preparedStatement = connection.prepareStatement("INSERT INTO student(firstName,lastName,age) VALUES(?,?,?)");
preparedStatement.setString(1, request.getParameter("fname"));
preparedStatement.setString(2, request.getParameter("lname"));
preparedStatement.setInt(3,
Integer.parseInt(request.getParameter("age")));
rowsAffected = preparedStatement.executeUpdate();
if(rowsAffected >0){
response.sendRedirect("insertform.jsp?success=true");
}
}catch(SQLException e){
out.println(e);
}finally{
try{
if(connection != null){
connection.close();
}
if(preparedStatement != null){
preparedStatement.close();
}
}catch(SQLException e){
	out.println(e);
	}
	}
	 }
	%>
}
</body>
</html>