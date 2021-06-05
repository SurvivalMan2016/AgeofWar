package com.example.project_game;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
public class MainActivity extends AppCompatActivity {

    private FragmentMenu fragmentMenu;
    private FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMenu = new FragmentMenu();
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame, fragmentMenu, getString(R.string.menu));
        fTrans.commit();

    }

    @Override
    public void onBackPressed() {
        FragmentMenu current = (FragmentMenu)getSupportFragmentManager().findFragmentByTag(getString(R.string.menu));
        if (current != null && current.isVisible()) {
            super.onBackPressed();
        }else{
            fragmentMenu = new FragmentMenu();
            fTrans = getSupportFragmentManager().beginTransaction();
            fTrans.replace(R.id.frame, fragmentMenu, getString(R.string.menu));
            fTrans.commit();
        }
    }
}
