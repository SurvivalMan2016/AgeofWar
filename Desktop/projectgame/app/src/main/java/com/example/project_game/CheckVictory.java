package com.example.project_game;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class CheckVictory {

    private Context context;
    private boolean victory = false;
    Sprite[][] sprites;

    CheckVictory(Context context, Sprite[][] sprites){
        this.context = context;
        this.sprites = sprites;
    }

    public boolean getVictory(){
        int filledCells = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(sprites[i][j] != null && sprites[i][j].getSpriteColor() == ContextCompat.getColor(context, R.color.colorActiveCell)){
                    filledCells++;
                }
            }
        }

        if(filledCells == Math.pow(sprites.length, 2))
            victory = true;

        return victory;
    }
}
