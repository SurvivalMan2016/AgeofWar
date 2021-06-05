package com.example.project_game;

import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentScene extends Fragment implements View.OnClickListener {

    private FrameLayout sceneFrame;
    private CreateScene createScene;
    private Display display;
    private Point size;
    private int indent, indentFrame, cellWeight;
    private final int CELLS = 3;
    public static FragmentScene fragmentScene;
    private Button replay, back;
    private FragmentMenu fragmentMenu;
    private FragmentTransaction fTrans;
    private TextView moveCounter;
    private MainApplication myApp;
    private Chronometer timeCounter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_scene, container, false);

        fragmentScene = this;

        myApp = ((MainApplication)getActivity().getApplicationContext());

        replay = (Button)view.findViewById(R.id.replay);
        replay.setOnClickListener(this);
        back = (Button)view.findViewById(R.id.back);
        back.setOnClickListener(this);
        replay.setVisibility(View.GONE);
        back.setVisibility(View.GONE);

        moveCounter = (TextView)view.findViewById(R.id.moveCounter);
        timeCounter = (Chronometer)view.findViewById(R.id.timeCounter);
        timeCounter.start();

        display = getActivity().getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);

        indentFrame = (size.x/15)/2;
        indent = ((size.y - size.x)/2) - indentFrame;
        cellWeight = (size.x - indentFrame*2)/CELLS;

        createScene = new CreateScene(getActivity(), cellWeight, indent, indentFrame);
        sceneFrame = (FrameLayout)view.findViewById(R.id.scene);
        sceneFrame.addView(createScene);

        return view;
    }

    public void showButton(){
        replay.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
    }

    public void setMoves(){
        moveCounter.setText(myApp.getCountMoves() + "");
    }

    public void startTimer(){
        timeCounter.setBase(SystemClock.elapsedRealtime());
        timeCounter.start();
    }

    public void stopTimer(){
        timeCounter.stop();
    }

    @Override
    public void onPause() {
        super.onPause();
        createScene.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        createScene.resume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.replay:
                replay.setVisibility(View.GONE);
                back.setVisibility(View.GONE);
                createScene.restartGame();
                break;
            case R.id.back:
                fragmentMenu = new FragmentMenu();
                fTrans = getActivity().getSupportFragmentManager().beginTransaction();
                fTrans.replace(R.id.frame, fragmentMenu, getString(R.string.menu));
                fTrans.commit();
                break;
        }
    }
}
