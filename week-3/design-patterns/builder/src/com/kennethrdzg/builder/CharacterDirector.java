package com.kennethrdzg.builder;

public class CharacterDirector {
    public PlayerCharacter constructCharacter(CharacterBuilder builder){
        // configure the character
        builder.buildRace();
        builder.buildAttributes();
        builder.buildSkills();
        return builder.getCharacter();
    }
}