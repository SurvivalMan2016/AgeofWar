package com.example.ageofwar;

import java.util.ArrayList;
import java.util.Collections;

public class Country {

    private final String ID_COUNTRY;
    private String name;
    private int money;
    private int econonomy;
    private ProvinceList<Province> provinces;

    public Country(String _id, String _name, int _money, int _economy, ProvinceList<Province> _provinces) {

        this.ID_COUNTRY = _id;
        this.name = _name;
        this.money = _money;
        this.econonomy = _economy;
        this.provinces = _provinces;

    }

}
