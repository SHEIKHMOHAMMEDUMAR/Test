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

@WebServlet("/addNewServlet")
public class addNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = (String)request.getParameter("name");
		int m_played = Integer.parseInt(request.getParameter("m_played"));
		int r_scored = Integer.parseInt(request.getParameter("r_scored"));
		int w_taken = Integer.parseInt(request.getParameter("w_taken"));
		int o_zero = Integer.parseInt(request.getParameter("o_zero"));
		String p_type = (String)request.getParameter("t_player");
		if(m_played < o_zero) {
			out.println("<h3 style='color: red;'>Out on zero can;t be more than matches played</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/addNewPage.html");
			rd.include(request, response);
			}
		else {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/umar", "root", "password");
			Statement stmt = con.createStatement();
			stmt.execute("insert into circket (Name, Matches_Played, Runs_Scored, Wicket_Taken, Out_on_zero, Player_Type) values"
					+ " ('"+name+"', "+m_played+", "+r_scored+", "+w_taken+", "+o_zero+", '"+p_type+"')");
			ResultSet rs = stmt.executeQuery("select ID from circket where Name = '"+name+"'");
			rs.next();
			out.println("Successfully added player with name : "+name+" and the player ID :"+rs.getInt(1));
			}
			catch(Exception e) {
				e.printStackTrace();
				out.println("Can't able to add player");
			}
		}
	}

}
