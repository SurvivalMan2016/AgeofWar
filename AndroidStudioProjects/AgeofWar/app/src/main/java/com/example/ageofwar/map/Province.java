package com.example.ageofwar.map;



import com.example.ageofwar.country.Country;
import com.example.ageofwar.country.CountryList;

public class Province {

    private int id; //ID of province for in-code operations
    private String name;//ID of province for in-game operations
    private int economy_lvl; //Level of economic development. More level we have that more money we get from this province
    private int development_lvl; //Level of technical development. More level we have that better increasing of economic development
    private boolean national_province = false;
    private int resistance;
    private String type;
    public Country first_owner;
    public Country owner;
    public Country controller;

    public Province(int _id) {

        this.id = _id;

    }

    public Province(int _id, String _name, int _economy_lvl, int _development_lvl, String _type, int _first_owner, int _owner, CountryList countries) {


    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEconomy_lvl() {
        return economy_lvl;
    }

    public int getDevelopment_lvl() {
        return development_lvl;
    }

    public boolean isNational_province() {
        return national_province;
    }

    public int getResistance() {
        return resistance;
    }

    public String getType() {
        return type;
    }
}
