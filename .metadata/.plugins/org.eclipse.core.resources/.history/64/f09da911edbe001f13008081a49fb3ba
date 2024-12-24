<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%@page import="java.sql.*, java.util.*, java.io.*, javax.servlet.*" %>
<%@page import="org.apache.commons.io.*, org.apache.commons.fileupload.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ImageUpload</title>
</head>
<body>
		<%
			File file = null;
			int maxMemorySize = 5000 * 1024;
			int maxFileSize = 5000 * 1024;
			String uploadDirectory = "/Users/sangeethkumarpg/jsp-worksapce/jsp-image-upload/src/main/webapp/uploads/";
			//String filePath = getServletContext().getRealPath(uploadDirectory);
			String contentType = request.getContentType();
			String fieldName = null;
			String fileName = null;
			int affectedRows = 0;
			if(contentType.indexOf("multipart/form-data") >= 0){
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				diskFileItemFactory.setSizeThreshold(maxMemorySize);
				diskFileItemFactory.setRepository(new File(uploadDirectory));
				ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
				upload.setSizeMax(maxFileSize);
				try{
					List fileItems = upload.parseRequest(request);
					Iterator iterator = fileItems.iterator();

					while(iterator.hasNext()){
						FileItem fileItem = (FileItem)iterator.next();
						if(!fileItem.isFormField()){
							fieldName = fileItem.getFieldName();
							fileName = fileItem.getName();
							boolean isInMemory = fileItem.isInMemory();
							long sizeInBytes = fileItem.getSize();
							file = new File(uploadDirectory + fileName);
							fileItem.write(file);
							System.out.println("File written successfully");
							//response.sendRedirect("index.jsp");
						}
					}
				}catch(Exception e){
					out.println(e);
				}
				if(file!=null && fileName!= null){
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					
					try{
						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
						preparedStatement = connection.prepareStatement("INSERT INTO images(image) VALUES(?)");
						String relativePath = "uploads/"  + fileName;
						preparedStatement.setString(1, relativePath);
						affectedRows = preparedStatement.executeUpdate();
						
						
					}catch(SQLException e){
						out.println(e);
					}finally{
						if(connection!=null){
							connection.close();
						}
						if(preparedStatement!=null){
							preparedStatement.close();
						}
						
					}
					if(affectedRows > 0){
						System.out.println("Image uploaded");
						
					}else{
						System.out.println("Upload error");
					}
					
				}
				
						
			}
		
		
		
		%>
		<c:redirect url="index.jsp"></c:redirect>
</body>
</html>