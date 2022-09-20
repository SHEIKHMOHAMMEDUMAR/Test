package com.circket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinalTeam")
public class FinalTeam extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public void addBowlers(List<PlayerInfo> playersSet, int nBowlers, List<PlayerInfo> finalEleven){
        int i = nBowlers;
        Iterator<PlayerInfo> itr = playersSet.iterator();
        List<PlayerInfo> bowlers = new ArrayList<>();
        while(itr.hasNext()){
            PlayerInfo p = itr.next();
            if(p.getPlayerType().equals("Bowler")){
                bowlers.add(p);
            }
        }
        Collections.sort(bowlers);
        ListIterator<PlayerInfo> itr1 = bowlers.listIterator(bowlers.size());
        while(i>0){
            PlayerInfo p = itr1.previous();
            finalEleven.add(p);
            i--;
        }
    }
	    
    public void addWicketers(List<PlayerInfo> playersSet, List<PlayerInfo> finalEleven){
        Iterator<PlayerInfo> itr = playersSet.iterator();
        List<PlayerInfo> wicketers = new ArrayList<>();
        while(itr.hasNext()){
            PlayerInfo p = itr.next();
            if(p.getPlayerType().equals("WicketKeeper")){
                wicketers.add(p);
            }
        }
        Collections.sort(wicketers);
        ListIterator<PlayerInfo> itr1 = wicketers.listIterator(wicketers.size());
        finalEleven.add(itr1.previous());
    }
	    
    public void addBatsmans(List<PlayerInfo> playersSet, int nBatsmans, List<PlayerInfo> finalEleven){
        int i = nBatsmans;
        Iterator<PlayerInfo> itr = playersSet.iterator();
        List<PlayerInfo> batsmans = new ArrayList<>();
        while(itr.hasNext()){
            PlayerInfo p = itr.next();
            if(p.getPlayerType().equals("Batsman") || p.getPlayerType().equals("AllRounder")){
                batsmans.add(p);
            }
        }
        Collections.sort(batsmans);
        ListIterator<PlayerInfo> itr1 = batsmans.listIterator(batsmans.size());
        while(i>0){
            PlayerInfo p = itr1.previous();
            finalEleven.add(p);
            i--;
        }
    }
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<link rel = 'stylesheet' href='homePage.css'>");
		out.println("Your final team is read...!");
		int bowlers = Integer.parseInt(request.getParameter("bowlers"));
		String wic = (String)request.getParameter("w_Keeper");
		List<PlayerInfo> playerSet = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/umar", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from circket");
			while(rs.next()) {
				PlayerInfo p = new PlayerInfo(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getString(7));
				playerSet.add(p);
			}
			List<PlayerInfo> finalEleven = new ArrayList<>();
			addBowlers(playerSet, bowlers, finalEleven);
	        if(wic.equals("Yes")){
	            addWicketers(playerSet, finalEleven);
	            addBatsmans(playerSet, 10 - bowlers, finalEleven);
	        }
	        else{
	            addBatsmans(playerSet, 11 - bowlers, finalEleven);
	        }
	        Collections.sort(finalEleven, new SortByName());
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
			Iterator<PlayerInfo> itr = finalEleven.iterator();
			while(itr.hasNext()) {
				PlayerInfo p = itr.next();
				out.println("<tr>"
						+ "<td>"+p.getId()+"</td>"
						+ "<td>"+p.getName()+"</td>"
						+ "<td>"+p.getMatchPlayed()+"</td>"
						+ "<td>"+p.getRunsScored()+"</td>"
						+ "<td>"+p.getWicketsTaken()+"</td>"
						+ "<td>"+p.getOutOnZero()+"</td>"
						+ "<td>"+p.getPlayerType()+"</td>"
						+ "</tr>");
			}
			out.println("</table>");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
