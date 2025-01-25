package com.reg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/RegistrationClass")
public class RegistrationClass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationClass() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        String email = request.getParameter("email");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        if (name != null && !name.isEmpty() &&
            password != null && !password.isEmpty() &&
            country != null && !country.isEmpty() &&
            email != null && !email.isEmpty()) {

            try {
                // Load MySQL Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Connect to Database
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1?useSSL=false&serverTimezone=UTC","root", "root");
                
                // SQL Query
                preparedStatement = connection.prepareStatement("INSERT INTO Registration(name, password, country, email) VALUES(?, ?, ?, ?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, country);
                preparedStatement.setString(4, email);
                
                int affectedRows = preparedStatement.executeUpdate();
                
                if (affectedRows > 0) {
                    out.println("<b>Registration Success!!</b>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<b>Error: " + e.getMessage() + "</b>");
            } finally {
                try {
                    if (preparedStatement != null) preparedStatement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            out.println("<b>All fields are required</b>");
            out.println("<a href=\"Register.html\">click here</a>");
        }

        out.println("<a href=\"Register.html\">click here</a>");
        out.close();
    }
}
