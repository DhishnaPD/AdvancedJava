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
int age = Integer.parseInt( request.getParameter("age"));
int id = Integer.parseInt(request.getParameter("id"));
int affectedRows = 0;
if(fname!= null && !fname.isEmpty() &&lname!=null && !lname.isEmpty() &&
request.getParameter("age") !=null &&
!request.getParameter("age").isEmpty() &&
request.getParameter("id") !=null &&
!request.getParameter("id").isEmpty()
){
Connection connection=null;
PreparedStatement preparedStatement = null;
try{
Class.forName("com.mysql.jdbc.Driver");
connection =
DriverManager.getConnection("jdbc:mysql://localhost/java1","root","root");
preparedStatement = connection.prepareStatement("UPDATE student SET firstName=?, lastName=?, age=? WHERE id=?");
preparedStatement.setString(1, fname);
preparedStatement.setString(2, lname);
preparedStatement.setInt(3, age);
preparedStatement.setInt(4, id);
affectedRows = preparedStatement.executeUpdate();
if(affectedRows > 0){
response.sendRedirect("viewdata.jsp?update:true");
}else{
response.sendRedirect("viewdata.jsp?updateError:true");
}
}catch(SQLException e){
	out.println(e);
	}finally{
	if(connection !=null){
	connection.close();
	}
	if(preparedStatement !=null){
	preparedStatement.close();
	}
	}
	}
%>
}
</body>
</html>