package com.example.ageofwar.country;

import android.graphics.Color;

import com.example.ageofwar.map.Province;
import com.example.ageofwar.map.ProvinceList;

import java.util.ArrayList;

public class Country {

    private String id_country;
    private String name;
    private int money;
    private int economy = setEconomy();
    private ArrayList<Province> provinces;
    private Unit soldier;

    public Country(String _id, String _name) {

        this.id_country = _id;
        this.name = _name;

    }

    public String getID_COUNTRY() {
        return id_country;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    public Unit getUnit() {
        return soldier;
    }

    public int getEconomy() {
        return economy;
    }

    public int setEconomy() {

        int _economy = 0;

        for (int i = 0; i <= provinces.size() - 1; i++) {

            _economy += provinces.get(i).getEconomy_lvl();

        }

        return _economy;

    }

    public void setMoney() {

        int profit = 0;

        profit = economy*2;

        money += profit;

    }
}
