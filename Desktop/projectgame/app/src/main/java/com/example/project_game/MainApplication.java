package com.example.project_game;

import android.app.Application;

public class MainApplication extends Application {

    private String gamemode = "Normal";
    private int countMoves;

    void setGamemode(String level){
        this.gamemode = level;
    }
    public String getGamemode(){
        return gamemode;
    }

    void setCountMoves(int count){
        this.countMoves = count;
    }

    public int getCountMoves(){
        return countMoves;
    }
}
