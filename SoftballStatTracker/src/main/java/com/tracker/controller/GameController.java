package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.entity.Team;
import com.tracker.service.GameService;

@CrossOrigin
@RestController
public class GameController {
	
	@Autowired
	GameService service;
	
//	@RequestMapping(value = "/games", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	public void startGame(@RequestBody List<Team> teams) {
//		service.startGame(teams.get(0),teams.get(1));
//	}
}
