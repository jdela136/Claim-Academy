package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.entity.League;
import com.tracker.service.LeagueService;

@CrossOrigin
@RestController
public class LeagueController {
	
	@Autowired
	LeagueService service;
	
	@RequestMapping(value = "/leagues", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void startLeague(@RequestBody League league) {
		service.startLeague(league);
		//service.send(league.getCommissioner().getEmail(),  "League Account Created" , "Your account was successfully created");
	}
	
	@RequestMapping(value = "/leagues", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<League>> findLeagues() {
		return new ResponseEntity<>(service.findLeagues(), HttpStatus.OK);
	}
}
