package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tracker.entity.PlateAppearance;
import com.tracker.entity.Team;
import com.tracker.service.PlateAppearanceService;

@CrossOrigin
@RestController
public class PlateAppearanceController {
	
	@Autowired
	PlateAppearanceService service;
	
	@RequestMapping(value = "/games", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void startGame(@RequestParam Integer awayId, @RequestParam Integer homeId) {
		service.startGame(awayId, homeId);
	}
	
	@RequestMapping(value = "/games/{gameId}/start-pa", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void startPA(@PathVariable Integer gameId) {
		service.startPA(gameId);
	}
	
	
	@RequestMapping(value = "/games/{gameId}/strike", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addStrike(@PathVariable Integer gameId) {
		service.addStrike(gameId);
	}
	
	@RequestMapping(value = "/games/{gameId}/ball", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addBall(@PathVariable Integer gameId) {
		service.addBall(gameId);
	}
	
	@RequestMapping(value = "/games/{gameId}/move", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void moveRunner(@PathVariable Integer gameId, @RequestParam Integer startingBase, @RequestParam Integer endingBase) {
		service.moveRunner(gameId, startingBase, endingBase);
	}
	
	@RequestMapping(value = "/games/{gameId}/hit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void baseHit(@PathVariable Integer gameId, @RequestParam Integer bases) {
		service.baseHit(gameId, bases);
	}
	
	@RequestMapping(value = "/games/{gameId}/out", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void outOnPlay(@PathVariable Integer gameId) {
		service.outOnPlay(gameId);
	}
	
	@RequestMapping(value = "/games/{gameId}/end", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void endGame(@PathVariable Integer gameId) {
		service.endGame(gameId);
	}
}
