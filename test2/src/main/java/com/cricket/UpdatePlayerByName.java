package com.cricket;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class UpdatePlayerByName {
    public boolean updatePlayer(HashSet<PlayerInfo> playersSet, String playerN) throws DucksOverloadException,RunsScoredWithoutMatchesPlayedException,WicketsTakenWithoutMatchesPlayedException{
        Iterator<PlayerInfo> itr = playersSet.iterator();
        while(itr.hasNext()){
            PlayerInfo p = itr.next();
            if(p.getName().equals(playerN)) {
                Scanner s = new Scanner(System.in);
                PlayerInfo p1 = new PlayerInfo();
                char dis;
                do{
                    System.out.println("Choose the information you want to update: ");
                    System.out.println("1 Player ID: ");
                    System.out.println("2 Player Name: ");
                    System.out.println("3 Matched Played: ");
                    System.out.println("4 Run Scored: ");
                    System.out.println("5 Wickets Taken: ");
                    System.out.println("6 Out on Zero: ");
                    System.out.println("7 Player Type: ");
                    switch (s.next()) {
                        case "1":
                            System.out.println("Please enter the new player ID: ");
                            p.setId(s.nextInt());
                            break;
                        case "2":
                            System.out.println("Please enter the name of the player:");
                            s.nextLine();
                            p.setName(s.nextLine());
                            break;
                        case "3":
                            System.out.println("Please enter the total number of matched played: ");
                            p.setMatchPlayed(s.nextLong());
                            break;
                        case "4":
                            System.out.println("Please enter the total number of runs scored: ");
                            p1.setRunsScored(s.nextLong());
                            break;
                        case "5":
                            System.out.println("Please enter the total number of wickets taken: ");
                            p1.setWicketsTaken(s.nextLong());
                            break;
                        case "6":
                            System.out.println("Please enter the total number of out's on zero: ");
                            p1.setOutOnZero(s.nextLong());
                            break;
                        case "7":
                            System.out.println("Please enter the type of player: ");
                            s.nextLine();
                            p.setPlayerType(s.next());
                            break;
                        default:
                            break;
                    }
                    if(p.getMatchPlayed()==0 && p1.getRunsScored()>0){
                        throw new RunsScoredWithoutMatchesPlayedException("Runs without playing");
                    }
                    else{
                        p.setRunsScored(p1.getRunsScored());
                    }
                    if(p.getMatchPlayed()==0 && p1.getWicketsTaken()>0){
                        throw new WicketsTakenWithoutMatchesPlayedException("Wickets taken without playing");
                    }
                    else{
                        p.setWicketsTaken(p1.getWicketsTaken());
                    }
                    if(p.getMatchPlayed()<p1.getOutOnZero()){
                        throw new DucksOverloadException("More Ducks");
                    }
                    else{
                        p.setOutOnZero(p1.getOutOnZero());
                    }
                    System.out.println("Do you want to change any other details [Y/N]");
                    dis = s.next().charAt(0);
                } while (dis == 'y' || dis == 'Y');
                return true;
            }
        }
        return false;
    }
}
