package com.cricket;

import java.util.Comparator;

public class SortByName implements Comparator<PlayerInfo> {
    @Override
    public int compare(PlayerInfo playerInfo, PlayerInfo t1) {
        return playerInfo.getName().compareTo(t1.getName());
    }
}