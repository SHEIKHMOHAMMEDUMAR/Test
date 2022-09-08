package com.cricket;

import java.util.HashSet;
import java.util.Scanner;

public class AddPlayerInformation extends CircketTeamSelection {
    public void addPlayer(HashSet<PlayerInfo> playersSet) throws PlayerAlreadyExisted,DucksOverloadException{
        Scanner s = new Scanner(System.in);
        PlayerInfo p = new PlayerInfo();
        System.out.println("Enter the details of the new player: ");
        System.out.println("Enter the player ID: ");
        p.setId(s.nextInt());
        System.out.println("Enter the name of the player: ");
        s.nextLine();
        p.setName(s.nextLine());
        System.out.println("Enter the total number of matches played: ");
        p.setMatchPlayed(s.nextLong());
        System.out.println("Enter the total number of runs scored: ");
        p.setRunsScored(s.nextLong());
        System.out.println("Enter the total number of wickets taken: ");
        p.setWicketsTaken(s.nextLong());
        System.out.println("Enter the total number of out's on zero: ");
        p.setOutOnZero(s.nextLong());
        System.out.println("Enter the type of player: ");
        s.nextLine();
        p.setPlayerType(s.next());
        if(p.getMatchPlayed()<p.getOutOnZero()){
            throw new DucksOverloadException("More Ducks");
        }
        if(playersSet.contains(p)){
            throw new PlayerAlreadyExisted("Already Existed");
        }
        else{
            playersSet.add(p);
        }
    }
}
