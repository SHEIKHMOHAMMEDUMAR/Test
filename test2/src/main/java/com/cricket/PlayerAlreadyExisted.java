package com.cricket;

public class PlayerAlreadyExisted extends Exception{
    public PlayerAlreadyExisted(String msg){
        super(msg);
    }
}
