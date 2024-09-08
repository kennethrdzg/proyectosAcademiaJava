package com.kennethrdzg.springRestJPA.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.kennethrdzg.springRestJPA.entity.VideoGame;
import com.kennethrdzg.springRestJPA.service.VideoGameService;

@RestController
@RequestMapping("/api")
public class VideoGameRestController {
	private VideoGameService service;
	
	@Autowired
	public VideoGameRestController(VideoGameService service) {
		this.service = service;
	}
	
	@GetMapping("/videogames")
	public List<VideoGame> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/videogames/{videoGameId}")
	public VideoGame getVideoGame(@PathVariable int videoGameId) {
		System.out.println("GAME ID: " + videoGameId);
		VideoGame videoGame = service.findById(videoGameId);
		if(videoGame == null) {
			throw new RuntimeException("Video Game ID is not found - " + videoGameId);
		}
		return videoGame;
	}
	
	@PostMapping("/videogames")
	public VideoGame addVideoGame(@RequestBody VideoGame videoGame) {
		videoGame.setId(0);
		
		VideoGame result = service.save(videoGame);
		
		return result;
	}
	
	@PutMapping("/videogames")
	public VideoGame updateVideoGame(@RequestBody VideoGame videoGame) {
		VideoGame result = service.save(videoGame);
		return result;
	}
	
	@DeleteMapping("/videogames/{videoGameId}")
	public void deleteVideoGame(@PathVariable int videoGameId) {
		VideoGame tempVideoGame = service.findById(videoGameId);
		
		if(tempVideoGame == null) {
			throw new RuntimeException("Video Game ID is not found - " + videoGameId);
		}
		service.deleteById(videoGameId);
	}
}
