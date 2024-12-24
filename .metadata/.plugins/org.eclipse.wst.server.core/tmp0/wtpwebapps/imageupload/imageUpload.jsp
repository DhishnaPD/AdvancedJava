<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.File" %>  <!-- Import File class -->
<%@ page import="org.apache.commons.fileupload.FileItem" %> <!-- Import Apache Commons FileUpload classes -->
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>  <!-- Disk File Item Factory -->
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %> <!-- ServletFileUpload class -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Image Upload</title>
</head>
<body>
    <form action="fileUploadDriver.jsp" method="POST" enctype="multipart/form-data">
        <label for="image">Image File</label>
        <input type="file" name="image" id="image" />
        <button type="submit">Upload</button>
    </form>
</body>
</html>
