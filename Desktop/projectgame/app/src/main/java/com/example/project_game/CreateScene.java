package com.example.project_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.content.ContextCompat;
import java.util.Random;

public class CreateScene extends SurfaceView implements Runnable {

    private Context context;
    private Thread thread = null;
    private SurfaceHolder holder;
    volatile boolean isOK = false;
    private int cellWeight, indent, indentFrame, xTouch, yTouch;
    private Paint paintScene, paintCell;
    private Sprite[][] sprites = new Sprite[3][3];
    private CheckVictory check;
    private boolean isVictory = false;
    private MainApplication myApp;


    public CreateScene(Context context, int weightCell, int indent, int indentFrame) {
        super(context);
        holder = getHolder();
        this.context = context;
        this.cellWeight = weightCell;
        this.indent = indent;
        this.indentFrame = indentFrame;

        myApp = ((MainApplication)context.getApplicationContext());

        paintCell = new Paint();
        paintScene = new Paint();
        paintScene.setColor(ContextCompat.getColor(context, R.color.colorScene));

        addSpriteToScene();
    }

    @Override
    public void run() {
        while (isOK) {
            if (!holder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = holder.lockCanvas();
            drawing(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }


    public void drawing(Canvas canvas){

        canvas.drawColor(ContextCompat.getColor(context, R.color.colorBackground));

        canvas.drawRoundRect(new RectF(indentFrame, indent, indentFrame + cellWeight * 3, indent + cellWeight * 3), 4, 4, paintScene);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(sprites[i][j]!=null){
                    sprites[i][j].draw(canvas, paintCell, cellWeight, i * cellWeight, j * cellWeight);
                }
            }
        }

        if(isVictory)
            canvas.drawColor(ContextCompat.getColor(context, R.color.colorSceneDark));


    }


    void addSpriteToScene(){
        if(myApp.getGamemode().equals(context.getString(R.string.normal))){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sprites[i][j] = new Sprite(context, ContextCompat.getColor(context, R.color.colorPassiveCell), indentFrame, indent);
                }
            }
        }else {
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(random.nextInt(2) == 0)
                        sprites[i][j] = new Sprite(context, ContextCompat.getColor(context, R.color.colorPassiveCell), indentFrame, indent);
                    else
                        sprites[i][j] = new Sprite(context, ContextCompat.getColor(context, R.color.colorActiveCell), indentFrame, indent);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        xTouch = (int)((event.getX()-indentFrame)/cellWeight);
        yTouch = (int)((event.getY()-indent)/cellWeight);

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getY() > indent && indent + cellWeight * 3 > event.getY()
                        && event.getX() > indentFrame && event.getX() < indentFrame + cellWeight * 3) {

                    myApp.setCountMoves(myApp.getCountMoves() + 1);
                    FragmentScene.fragmentScene.setMoves();

                    if (sprites[xTouch][yTouch] != null) {
                        changeSpriteColor(xTouch, yTouch);
                        changeSpriteColor(xTouch + 1, yTouch);
                        changeSpriteColor(xTouch - 1, yTouch);
                        changeSpriteColor(xTouch, yTouch + 1);
                        changeSpriteColor(xTouch, yTouch - 1);
                    }

                    check = new CheckVictory(context, sprites);
                    if(check.getVictory()){
                        FragmentScene.fragmentScene.showButton();
                        FragmentScene.fragmentScene.stopTimer();
                        isVictory = true;
                    }
                }
                return true;
        }
        return false;
    }

    void changeSpriteColor(int x, int y){
        if(x >= 0 && y >= 0 && x < 3 && y < 3)
            if(sprites[x][y].getSpriteColor() == ContextCompat.getColor(context, R.color.colorActiveCell))
                sprites[x][y].setSpriteColor(ContextCompat.getColor(context, R.color.colorPassiveCell));
            else
                sprites[x][y].setSpriteColor(ContextCompat.getColor(context, R.color.colorActiveCell));
    }

    public void pause() {
        isOK = false;
        while (true) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        thread = null;
        myApp.setCountMoves(0);
    }

    public void resume() {
        isOK = true;
        thread = new Thread(this);
        thread.start();
    }

    public void restartGame(){
        myApp.setCountMoves(0);
        FragmentScene.fragmentScene.setMoves();
        addSpriteToScene();
        isVictory = false;
        FragmentScene.fragmentScene.startTimer();
    }
}
