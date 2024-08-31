package com.kennethrdzg.builder;

public interface CharacterBuilder {
    void buildRace();
    void buildAttributes();
    void buildSkills();
    PlayerCharacter getCharacter();
}