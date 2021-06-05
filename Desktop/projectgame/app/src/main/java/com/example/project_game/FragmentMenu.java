package com.example.project_game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentMenu extends Fragment implements View.OnClickListener {

    private Button play;
    private FragmentScene fragmentScene;
    private FragmentTransaction fTrans;
    private RadioButton radioButtonNormal, radioButtonRandom;
    private RadioGroup radioGroup;
    private MainApplication myApp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);

        myApp = ((MainApplication)getActivity().getApplicationContext());

        play = (Button)view.findViewById(R.id.play);
        play.setOnClickListener(this);

        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroupType);
        radioButtonNormal = (RadioButton) view.findViewById(R.id.normal);
        radioButtonRandom = (RadioButton) view.findViewById(R.id.random);

        if(myApp.getGamemode().equals(getString(R.string.normal)))
            radioGroup.check(R.id.normal);
        else
            radioGroup.check(R.id.random);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.normal:
                        myApp.setGamemode(getString(R.string.normal));
                        break;
                    case R.id.random:
                        myApp.setGamemode(getString(R.string.random));
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                fragmentScene = new FragmentScene();
                fTrans = getActivity().getSupportFragmentManager().beginTransaction();
                fTrans.replace(R.id.frame, fragmentScene);
                fTrans.commit();

                break;
        }
    }


}
