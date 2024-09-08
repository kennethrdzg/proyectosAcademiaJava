package com.kennethrdzg.crudJPA.videoGameREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kennethrdzg.crudJPA.videoGameREST.entity.VideoGame;
import com.kennethrdzg.crudJPA.videoGameREST.service.VideoGameService;

@RestController
@RequestMapping("/api")
public class VideoGameRestController{
    private VideoGameService service;

    @Autowired
    public VideoGameRestController(VideoGameService service){
        this.service = service;
    }

    @GetMapping("/videogames")
    public List<VideoGame> findAll(){
        return service.findAll();
    }
}