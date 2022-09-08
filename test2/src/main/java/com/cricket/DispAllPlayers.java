package com.cricket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class DispAllPlayers{
    public void dispAllPlayers(List<PlayerInfo> playersList){
        Collections.sort(playersList, new SortByName());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ID | Name                  | Matches Played | Runs Scored | Wickets Taken | Out on Zero | Player Type ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(PlayerInfo p: playersList){
            System.out.printf("%2d | %20s | %15d | %11d | %13d | %12d | %10s",p.getId(),p.getName(),p.getMatchPlayed(),p.getRunsScored(),p.getWicketsTaken(),p.getOutOnZero(),p.getPlayerType());
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
