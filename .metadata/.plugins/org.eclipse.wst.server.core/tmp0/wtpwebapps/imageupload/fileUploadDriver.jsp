<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.sql.*" %> <!-- If you're saving to DB, include JDBC imports -->
<%
    // Define max sizes for the upload
    int maxMemorySize = 5000 * 1024;  // 5 MB in memory
    int maxFileSize = 5000 * 1024;    // 5 MB for the max file size
    String uploadDirectory = "D:/eclipse/imageupload/src/main/webapp/uploads/";  // Update the path for your environment
   //String uploadDirectory = "uploads/";
    // Ensure the upload directory exists
    File uploadDir = new File(uploadDirectory);
    if (!uploadDir.exists()) {
        uploadDir.mkdirs();  // Create the directory (and parent directories) if it doesn't exist
    }

    String contentType = request.getContentType();
    if (contentType != null && contentType.indexOf("multipart/form-data") >= 0) {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(maxMemorySize);  // Set size threshold in memory
        diskFileItemFactory.setRepository(new File(uploadDirectory));  // Temporary directory for files larger than threshold

        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        upload.setSizeMax(maxFileSize);  // Set max file size for uploads

        try {
            // Parse the request to extract file items
            List<FileItem> fileItems = upload.parseRequest(request);
            Iterator<FileItem> iterator = fileItems.iterator();
            
            while (iterator.hasNext()) {
                FileItem fileItem = iterator.next();
                
                // Process the uploaded file (not form fields)
                if (!fileItem.isFormField()) {
                    String fileName = fileItem.getName();
                    // For Windows, remove the full path and get only the file name
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    
                    // Ensure a unique file name to avoid overwriting
                    File file = new File(uploadDirectory + fileName);
                    String uniqueFileName = null;
                    if (file.exists()) {
                        // If the file exists, append a timestamp or unique identifier
                        uniqueFileName = System.currentTimeMillis() + "_" + fileName;
                        out.println("uniquefilename"+uniqueFileName);
                        file = new File(uploadDirectory + uniqueFileName);
                        
                    }
                    
                    // Write the uploaded file to the target directory
                    fileItem.write(file);  // Save the file to disk
                    
                    // Optionally, you can store the file path into a database
                    // (if you're keeping track of uploaded files)
                    String filePath = uploadDirectory + file.getName();
                    // Example DB insertion (update with your DB details)
                    Connection connection = null;
                    PreparedStatement statement = null;
                    try {
                    	Class.forName("com.mysql.cj.jdbc.Driver");
                        String dbURL = "jdbc:mysql://localhost:3306/java1";  // Change DB URL
                        String dbUser = "root";  // Change DB user
                        String dbPassword = "root";  // Change DB password
                        connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
                        
                        String sql = "INSERT INTO images (image) VALUES (?)";  // Example query
                        statement = connection.prepareStatement(sql);
                        statement.setString(1, uniqueFileName);
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        out.println("Database error: " + e.getMessage());
                    } finally {
                        if (connection != null) {
                            connection.close();
                        }
                        if (statement != null) {
                            statement.close();
                        }
                    }

                    out.println("File uploaded successfully: " + uniqueFileName+"");
                }
            }
        } catch (Exception e) {
            out.println("Error during file upload: " + e.getMessage());
        }
    } else {
        out.println("Form is not submitted with multipart/form-data.");
    }
%>
