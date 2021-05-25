package com.example.ageofwar.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.ageofwar.R;
import com.example.ageofwar.country.Country;
import com.example.ageofwar.country.CountryList;

import java.io.File;
import java.util.ArrayList;


public class CountryFragment extends Fragment {

    private ListView country_list;
    private ArrayList<Country> cl;

    public CountryFragment() {
        CountryList countryList=new CountryList();
        cl=countryList.getCountryList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_country, container, false);
        country_list=v.findViewById(R.id.country_list);
        return v;
    }
}