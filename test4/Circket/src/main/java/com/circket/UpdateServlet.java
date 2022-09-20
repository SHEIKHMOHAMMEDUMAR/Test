package com.circket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel = 'stylesheet' href='homePage.css'>");
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		int m_played = (int)session.getAttribute("m_played");
		int r_scored = (int)session.getAttribute("r_scored");
		int w_taken = (int)session.getAttribute("w_taken");
		int o_zero = (int)session.getAttribute("o_zero");
		
		session.setAttribute("id", id);
		out.println("<form action='UpdateDatabase'>"
				+ "<h1> Update user with id:"+id+"</h1>"
				+ "<p> Enter the new name </p> <input type='text' value="+name+" name='name'>"
				+ "<p> Enter the new matched played by the player </p> <input type='number' value="+m_played+" name='m_played'>"
				+ "<p> Enter the new runs scored by the player </p> <input type='number' value="+r_scored+" name='r_scored'>"
				+ "<p> Enter the new wickets taken by the player </p> <input type='number' value="+w_taken+" name='w_taken'>"
				+ "<p> Enter the new out on zero by the player </p> <input type='number' value="+o_zero+" name='o_zero'>"
				+ "<p> Choose the type of the player </p> "
				+ "<input type='radio' value='Batsman' name='p_type'>Batsman"
				+ "<input type='radio' value='Bowler' name='p_type'>Bowler"
				+ "<input type='radio' value='AllRounder' name='p_type'>AllRounder"
				+ "<input type='radio' value='WicketKeeper' name='p_type'>WicketKeeper"
				+ "<input type='submit' value='Update'>"
				+ "</form>");		
	}

}
