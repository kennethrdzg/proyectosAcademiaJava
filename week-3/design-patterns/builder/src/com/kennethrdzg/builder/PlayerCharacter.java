package com.kennethrdzg.builder;

import java.util.List;

public class PlayerCharacter{
    String name;
    FantasyRace race;
    int strength;
    int dexterity;
    int willpower;
    List<Skills> skills;

    public PlayerCharacter(String name){
        this.name = name;
        this.strength = 10;
        this.dexterity = 10;
        this.willpower = 10;
    }

    public void setFantasyRace(FantasyRace fantasyRace){
        this.race = fantasyRace;
    }

    public void setSkills(List<Skills> skills){
        this.skills = skills;
    }

    @Override
    public String toString(){
        return this.race + " " + this.name + ":"
        + "\n- STR: " + this.strength + "\n- DEX: " + this.dexterity
        + "\n- WILL: " + this.willpower
        + "\n- Skills: " + this.skills;
    }
}