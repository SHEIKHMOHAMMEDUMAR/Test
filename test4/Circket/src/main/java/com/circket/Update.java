package com.circket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Update() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel = 'stylesheet' href='homePage.css'>");
		int id = Integer.parseInt(request.getParameter("ID"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/umar", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from circket where ID = "+id);
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("id", rs.getInt(1));
				session.setAttribute("name", rs.getString(2));
				session.setAttribute("m_played", rs.getInt(3));
				session.setAttribute("r_scored", rs.getInt(4));
				session.setAttribute("w_taken", rs.getInt(5));
				session.setAttribute("o_zero", rs.getInt(6));
				session.setAttribute("p_type", rs.getString(7));
				RequestDispatcher rd = request.getRequestDispatcher("UpdateServlet");
				rd.forward(request, response);
			}
			else {
				out.println("<h3 style='color: red;'>Please enter a valid player ID</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/updatePage.html");
				rd.include(request, response);
			}
			con.close();
		}
		catch(Exception e){
			out.println("Can't connect to the database");
		}
		
	}

}
