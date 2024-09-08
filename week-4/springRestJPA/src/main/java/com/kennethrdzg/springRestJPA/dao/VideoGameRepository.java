package com.kennethrdzg.springRestJPA.dao;

import com.kennethrdzg.springRestJPA.entity.VideoGame;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoGameRepository extends JpaRepository<VideoGame, Integer>{}
