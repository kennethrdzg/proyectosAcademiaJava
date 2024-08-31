package com.kennethrdzg.builder;

import java.util.List;

public class ElfBuilder implements CharacterBuilder{
    private PlayerCharacter character;

    public ElfBuilder(String name){
        this.character = new PlayerCharacter(name);
    }

    @Override
    public void buildRace(){
        this.character.setFantasyRace(FantasyRace.ELF);
    }

    @Override
    public void buildAttributes(){
        this.character.dexterity += 3;
        this.character.strength += 1;
    }

    @Override
    public void buildSkills(){
        List<Skills> skills = List.of(Skills.ARCHERY, Skills.STEALTH);
        this.character.setSkills(skills);
    }

    @Override
    public PlayerCharacter getCharacter(){
        return this.character;
    }
}