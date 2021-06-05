package com.example.project_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.content.ContextCompat;

public class Sprite {

    private int color;
    private int indentFrame;
    private int indent;
    private Context context;

    public Sprite( Context context, int spriteColor, int indentF, int indent){
        this.context = context;
        this.color = spriteColor;
        this.indentFrame = indentF;
        this.indent = indent;
    }

    public void setSpriteColor (int spriteColor){
        this.color = spriteColor;
    }
    public int getSpriteColor(){
        return color;
    }
    public void draw(Canvas canvas, Paint p, int weight, int x, int y) {
        p.setColor(color);
        p.setShadowLayer(5.0f, 1.0f, 1.0f, ContextCompat.getColor(context, R.color.colorShadow));
        canvas.drawRoundRect(new RectF((x + 5) + indentFrame, y + 5 + indent, (x + weight - 5) + indentFrame, y + weight - 5 + indent), 3, 3, p);
    }
}
