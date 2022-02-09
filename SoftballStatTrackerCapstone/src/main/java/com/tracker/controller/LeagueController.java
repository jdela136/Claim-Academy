package com.tracker.controller;

import java.util.List;
import java.util.Optional;

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
import com.tracker.service.SendMail;

@CrossOrigin
@RestController
public class LeagueController {
	
	@Autowired
	LeagueService service;
	
	@Autowired
	SendMail mailSender;
	
	@RequestMapping(value = "/leagues", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void startLeague(@RequestBody League league) {
		service.startLeague(league);
		mailSender.send(league.getCommissioner().getEmail(),  "League Account Created" , "Your account was successfully created");
	}
	
//	@RequestMapping(value = "/leagues", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//	public ResponseEntity<List<League>> findLeagues() {
//		return new ResponseEntity<>(service.findLeagues(), HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Optional<League>> login(@RequestBody League league) {
		Optional<League> dbLeague = service.getLeagueByCommisionerEmail(league.getCommissioner().getEmail());
		if (dbLeague.isPresent()) {
			if (dbLeague.get().getCommissioner().getPassword().equals(league.getCommissioner().getPassword())) {
				return new ResponseEntity<>(dbLeague, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/league", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Optional<League>> findLeagueByEmail(String email) {
		return new ResponseEntity<>(service.getLeagueByCommisionerEmail(email), HttpStatus.OK);
	}
}
