package com.example.ageofwar.country;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class CountryList {

    private ArrayList<Country> countries_global = new ArrayList<>();

    private void importCountries(Context context) {

        File f=new File(context.getAssets()+"/countries");
        for (File file:f.listFiles()){

            try {
                FileOutputStream fos = context.openFileOutput(file.getPath(),Context.MODE_PRIVATE);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson g = gsonBuilder.create();
                Country c = g.fromJson(String.valueOf(fos), Country.class);
                countries_global.add(c);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

    }

    public ArrayList<Country> getCountryList() {return countries_global;}

    public CountryList() {
    }


}
