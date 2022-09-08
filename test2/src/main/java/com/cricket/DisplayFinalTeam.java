package com.cricket;

import java.util.*;

public class DisplayFinalTeam {
    public void addBowlers(HashSet<PlayerInfo> playersSet, int nBowlers, List<PlayerInfo> finalEleven){
        int i = nBowlers;
        Iterator<PlayerInfo> itr = playersSet.iterator();
        List<PlayerInfo> bowlers = new ArrayList<>();
        while(itr.hasNext()){
            PlayerInfo p = itr.next();
            if(p.getPlayerType().equals("Bowler") || p.getPlayerType().equals("AllRounder")){
                bowlers.add(p);
            }
        }
        Collections.sort(bowlers);
        Iterator<PlayerInfo> itr1 = bowlers.iterator();
        while(i>0){
            PlayerInfo p = itr1.next();
            finalEleven.add(p);
            i--;
        }
    }
    public void addWicketers(HashSet<PlayerInfo> playersSet, List<PlayerInfo> finalEleven){
        Iterator<PlayerInfo> itr = playersSet.iterator();
        List<PlayerInfo> wicketers = new ArrayList<>();
        while(itr.hasNext()){
            PlayerInfo p = itr.next();
            if(p.getPlayerType().equals("WicketKeeper")){
                wicketers.add(p);
            }
        }
        Collections.sort(wicketers);
        Iterator<PlayerInfo> itr1 = wicketers.iterator();
        finalEleven.add(itr1.next());
    }
    public void addBatsmans(HashSet<PlayerInfo> playersSet, int nBatsmans, List<PlayerInfo> finalEleven){
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
        Iterator<PlayerInfo> itr1 = batsmans.iterator();
        while(i>0){
            PlayerInfo p = itr1.next();
            finalEleven.add(p);
            i--;
        }
    }
    public void dispFinalTeam(HashSet<PlayerInfo> playersSet)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of bowlers you want in the team: ");
        int bowlers = s.nextInt();
        System.out.println("Do you want wicket-keeper in your team [Y/N]: ");
        char wicketDis = s.next().charAt(0);
        List<PlayerInfo> finalEleven = new ArrayList<>();
        addBowlers(playersSet, bowlers, finalEleven);
        if(wicketDis == 'y' || wicketDis == 'Y'){
            addWicketers(playersSet, finalEleven);
            addBatsmans(playersSet, 10 - bowlers, finalEleven);
        }
        else{
            addBatsmans(playersSet, 11 - bowlers, finalEleven);
        }
        DispAllPlayers dap = new DispAllPlayers();
        dap.dispAllPlayers(finalEleven);
    }
}
