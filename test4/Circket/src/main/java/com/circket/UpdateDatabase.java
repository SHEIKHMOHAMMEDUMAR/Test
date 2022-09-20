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
import javax.servlet.http.HttpSession;
@WebServlet("/UpdateDatabase")
public class UpdateDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		String name = (String)request.getParameter("name");
		int m_played = Integer.parseInt(request.getParameter("m_played"));
		int r_scored = Integer.parseInt(request.getParameter("r_scored"));
		int w_taken = Integer.parseInt(request.getParameter("w_taken"));
		int o_zero = Integer.parseInt(request.getParameter("o_zero"));
		String p_type = (String)request.getParameter("p_type");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/umar", "root", "password");
		Statement stmt = con.createStatement();
		stmt.execute("update circket set Name = '"+name+"',"
				+ "Matches_Played = "+m_played+","
				+ "Runs_Scored = "+r_scored+","
				+ "Wicket_Taken = "+w_taken+","
				+ "Out_on_zero = "+o_zero+","
				+ "Player_Type = '"+p_type
				+ "' where ID = "+id);
		out.println("Successfully updated the information of player with ID : "+id);
		}
		catch(Exception e) {
			e.printStackTrace();
			out.println("Can't able to update");
		}
	}

}
