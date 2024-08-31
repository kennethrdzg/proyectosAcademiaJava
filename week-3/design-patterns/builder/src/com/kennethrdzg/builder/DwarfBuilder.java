package com.kennethrdzg.builder;

import java.util.List;

public class DwarfBuilder implements CharacterBuilder{
    private PlayerCharacter character;

    public DwarfBuilder(String name){
        this.character = new PlayerCharacter(name);
    }

    @Override
    public void buildRace(){
        this.character.setFantasyRace(FantasyRace.DWARF);
    }

    @Override
    public void buildAttributes(){
        this.character.strength += 2;
        this.character.willpower += 2;
    }

    @Override
    public void buildSkills(){
        List<Skills> skills = List.of(Skills.MINING, Skills.SMITHING);
        this.character.setSkills(skills);
    }

    @Override
    public PlayerCharacter getCharacter(){
        return this.character;
    }
}