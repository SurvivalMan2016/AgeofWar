package com.example.ageofwar.country;

import com.example.ageofwar.map.Province;
import com.example.ageofwar.country.Bonuses;

public class Unit {

    private String tag;
    private String name;
    private double attack;
    private double defense;
    private double health_points;
    private Province location;

    public Unit(String _tag, String _name, double _attack, double _deffence, double _health){

        this.tag = _tag;
        this.name = _name;
        this.attack = _attack;
        this.defense = _deffence;
        this.health_points = _health;

    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDeffense() {
        return defense;
    }

    public void setDefense(double _defense) {
        this.defense = _defense;
    }

    public double getHealth() {
        return health_points;
    }

    public void setHealth(double health_points) {
        this.health_points = health_points;
    }

    public void changeLocation(Province endPoint) {

        this.location = endPoint;

    }

    public void setStats(Province province){

            Bonuses b = new Bonuses();

        if (b.types[0].equals(province.getType())){

            double _attack = getAttack();
            setAttack(_attack * 0.25);

            double _defense = getDeffense();
            setDefense(_defense * 0.07);

        }

        else if (b.types[1].equals(province.getType())){

            double _attack = getAttack();
            setAttack(_attack * 1.00);

            double _defense = getDeffense();
            setDefense(_defense * 0.90);

        }

        else if (b.types[2].equals(province.getType())){

            double _attack = getAttack();
            setAttack(_attack * 0.30);

            double _defense = getDeffense();
            setDefense(_defense * 1.50);

        }

        else if (b.types[3].equals(province.getType())){

            double _attack = getAttack();
            setAttack(_attack * 0.50);

            double _defense = getDeffense();
            setDefense(_defense * 0.85);

        }

        else if (b.types[4].equals(province.getType())){

            double _attack = getAttack();
            setAttack(_attack * 0.20);

            double _defense = getDeffense();
            setDefense(_defense * 0.03);

        }

    }

    /*public void fight(Country c1, Country c2){

        Unit u1 = c1.getUnit();
        Unit u2 = c2.getUnit();

        u1.setStats(location);
        u2.setStats(location);

        u1.setHealth(health_points - attack * defense);
        u2.setHealth(health_points - attack * defense);

        if (u1.health_points <= 0) delete(u1);
        else if (u2.health_points <= 0) delete(u2);


    }*/

}


