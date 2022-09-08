package com.cricket;

import java.util.HashSet;

public class StaticPlayersList extends CircketTeamSelection{
    public void playersList(HashSet<PlayerInfo> playersSet){
        int id=1;
        playersSet.add(new PlayerInfo(id++,"Umar",100,1200,10,13,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Muzammil",120,2400,1,24,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Adithya",130,1300,2,40,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Arjit",140,1000,20,44,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Venkat",150,600,200,70,"Bowler"));
        playersSet.add(new PlayerInfo(id++,"Virat",160,3600,0,10,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Jatin",17,50,20,13,"Bowler"));
        playersSet.add(new PlayerInfo(id++,"Adithya V",180,1200,120,37,"AllRounder"));
        playersSet.add(new PlayerInfo(id++,"Rohit",10,80,20,6,"Bowler"));
        playersSet.add(new PlayerInfo(id++,"Namith",100,200,93,57,"Bowler"));
        playersSet.add(new PlayerInfo(id++,"Animesh",100,2400,80,23,"AllRounder"));
        playersSet.add(new PlayerInfo(id++,"Adithya P",210,890,1,29,"WicketKeeper"));
        playersSet.add(new PlayerInfo(id++,"Dilip",40,600,8,8,"WicketKeeper"));
        playersSet.add(new PlayerInfo(id++,"Sahil",60,1000,0,17,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Arvind",30,90,40,15,"Bowler"));
        playersSet.add(new PlayerInfo(id++,"Pavan",25,400,20,10,"AllRounder"));
        playersSet.add(new PlayerInfo(id++,"Parmod",37,600,0,23,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Saurav",90,1200,0,23,"Batsman"));
        playersSet.add(new PlayerInfo(id++,"Balaji",300,5400,140,93,"AllRounder"));
        playersSet.add(new PlayerInfo(id,"Nilesh",450,2400,400,120,"Bowler"));
    }

}
