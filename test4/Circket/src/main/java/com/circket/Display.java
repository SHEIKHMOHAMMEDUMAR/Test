package com.circket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/umar", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from circket");
			out.println("<link rel = 'stylesheet' href='homePage.css'>");
			out.println("<table>"
					+ "<tr>"
					+ "<th>Player ID</th>"
					+ "<th>Player name</th>"
					+ "<th>Matches played</th>"
					+ "<th>Runs scored</th>"
					+ "<th>Wickets taken</th>"
					+ "<th>Out on zero</th>"
					+ "<th>Player type</th>"
					+ "</tr>");
			while(rs.next()) {
				out.println("<tr>"
						+ "<td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getInt(3)+"</td>"
						+ "<td>"+rs.getInt(4)+"</td>"
						+ "<td>"+rs.getInt(5)+"</td>"
						+ "<td>"+rs.getInt(6)+"</td>"
						+ "<td>"+rs.getString(7)+"</td>"
						+ "</tr>");
			}
			out.println("</table>");
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
			out.println("Can't connect to the database");
		}
		
	}

}
