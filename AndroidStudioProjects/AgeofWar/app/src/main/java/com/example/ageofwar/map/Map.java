package com.example.ageofwar.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Map extends Drawable {
    private Pt[] myPath={};

    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();

        // переходим в первую точку рисования
        path.moveTo(myPath[0].x, myPath[0].y);

        // рисуем отрезки по заданным точкам
        for (int i = 1; i < myPath.length; i++){
            path.lineTo(myPath[i].x, myPath[i].y);
        }

        // выводим результат
        canvas.drawPath(path, paint);
    }


    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @SuppressLint("WrongConstant")
    @Override
    public int getOpacity() {
        return 0;
    }
}