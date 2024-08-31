package com.kennethrdzg.builder;

import java.util.List;

public class HumanBuilder implements CharacterBuilder{
    private PlayerCharacter character;

    public HumanBuilder(String name){
        this.character = new PlayerCharacter(name);
    }

    @Override
    public void buildRace(){
        this.character.setFantasyRace(FantasyRace.HUMAN);
    }

    @Override
    public void buildAttributes(){
        this.character.dexterity += 1;
        this.character.strength += 1;
        this.character.willpower += 2;
    }

    @Override
    public void buildSkills(){
        List<Skills> skills = List.of(Skills.COOKING, Skills.DIPLOMACY);
        this.character.setSkills(skills);
    }

    @Override
    public PlayerCharacter getCharacter(){
        return this.character;
    }
}