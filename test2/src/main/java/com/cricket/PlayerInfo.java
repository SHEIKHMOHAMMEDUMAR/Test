package com.cricket;

import java.util.Objects;

public class PlayerInfo implements Comparable<PlayerInfo> {
    int id;
    String name;
    long matchPlayed;
    long runsScored;
    long wicketsTaken;
    long outOnZero;
    String playerType;
    Double performanceScore;

    public PlayerInfo(int id, String name, long matchPlayed, long runsScored, long wicketsTaken, long outOnZero, String playerType) {
        this.id = id;
        this.name = name;
        this.matchPlayed = matchPlayed;
        this.runsScored = runsScored;
        this.wicketsTaken = wicketsTaken;
        this.outOnZero = outOnZero;
        this.playerType = playerType;
        switch (this.playerType) {
            case "Batsman":
            case "WicketKeeper":
                this.performanceScore = this.runsScored / (double) (this.matchPlayed);
                break;
            case "Bowler":
                this.performanceScore = this.wicketsTaken / (double) (this.matchPlayed);
                break;
            case "AllRounder":
                this.performanceScore = ((this.runsScored / (double) (this.matchPlayed)) + (this.wicketsTaken / (double) (this.matchPlayed))) / 2;
                break;
            default:
                break;
        }
    }
    public PlayerInfo(){
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getMatchPlayed() {
        return matchPlayed;
    }
    public void setMatchPlayed(long matchPlayed) {
        this.matchPlayed = matchPlayed;
    }
    public long getRunsScored() {
        return runsScored;
    }
    public void setRunsScored(long runsScored) {
        this.runsScored = runsScored;
    }
    public long getWicketsTaken() {
        return wicketsTaken;
    }
    public void setWicketsTaken(long wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }
    public long getOutOnZero() {
        return outOnZero;
    }
    public void setOutOnZero(long outOnZero) {
        this.outOnZero = outOnZero;
    }
    public String getPlayerType() {
        return playerType;
    }
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
    public Double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Double performanceScore) {
        this.performanceScore = performanceScore;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerInfo that = (PlayerInfo) o;
        return id == that.id && matchPlayed == that.matchPlayed && runsScored == that.runsScored && wicketsTaken == that.wicketsTaken && outOnZero == that.outOnZero && Objects.equals(name, that.name) && Objects.equals(playerType, that.playerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, matchPlayed, runsScored, wicketsTaken, outOnZero, playerType);
    }

    @Override
    public int compareTo(PlayerInfo p) {
        return (int) (this.performanceScore - p.getPerformanceScore());
    }
}