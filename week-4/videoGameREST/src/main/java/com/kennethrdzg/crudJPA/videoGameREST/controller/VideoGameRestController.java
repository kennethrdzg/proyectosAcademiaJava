package com.kennethrdzg.crudJPA.videoGameREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/videogames/{videoGameId}")
    public VideoGame getVideoGame(@PathVariable int videoGameId){
        VideoGame videoGame = service.findById(videoGameId);
        if(videoGame == null)
            throw new RuntimeException("Could not find Video Game with ID: " + videoGameId);
        return videoGame;
    }

    @PostMapping("/videogames")
    public VideoGame postVideoGame(@RequestBody VideoGame videoGame){
        videoGame.setId(0);
        VideoGame result = service.save(videoGame);
        return result;
    }

    @PutMapping("/videogames")
    public VideoGame putVideoGame(@RequestBody VideoGame videoGame){
        VideoGame result = service.update(videoGame);
        return result;
    }

    @DeleteMapping("/videogames/{videoGameId}")
    public void deleteVideoGame(@PathVariable int videoGameId){
        VideoGame tempVideoGame = service.findById(videoGameId);

        if(tempVideoGame == null){
            throw new RuntimeException("Video Game ID was not found: " + videoGameId);
        }
        service.delete(videoGameId);
    }
}