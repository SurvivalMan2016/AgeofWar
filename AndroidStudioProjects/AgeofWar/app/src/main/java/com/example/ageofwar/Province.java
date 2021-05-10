package com.example.ageofwar;

public class Province {

    private final int id; //ID of province for in-code operations
    private final String name;//Name of province for in-game operations
    private final int economy_lvl; //Level of economic development. More level we have that more money we get from this province
    private final int development_lvl; //Level of technical development. More level we have that better increasing of economic development
    private boolean national_province = false;
    private int resistance;

    public Province (int _id, String _name, int _economy_lvl, int _development_lvl, boolean _national_province) {

        this.id = _id;
        this.name = _name;
        this.economy_lvl = _economy_lvl;
        this.development_lvl = _development_lvl;
        national_province = _national_province;

    }

    public void Nationalize(int id, String name, boolean national_province) {

        national_province = true;

    }

}
