package com.example.ageofwar.map;

import com.example.ageofwar.country.Country;

import java.util.ArrayList;
import java.util.List;

public class ProvinceList {

        public ArrayList<Province> provinces_general = new ArrayList<>();

        public ProvinceList(ArrayList<Province> provinces_general) {
                this.provinces_general = provinces_general;
        }

        public Province getProvByID(int id) {
                for (int i = 0; i < provinces_general.size(); i++) {
                        if (provinces_general.get(i).getID() == id) return provinces_general.get(i);
                }
                return null;
        }
}
