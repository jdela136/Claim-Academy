package com.tracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.entity.Team;
import com.tracker.service.TeamService;

@CrossOrigin
@RestController
public class TeamController {
	
	@Autowired
	TeamService service;
	
	@RequestMapping(value = "/leagues/{leagueId}/teams", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addTeam(@RequestBody Team team , @RequestParam Integer leagueId) {
		service.addTeam(team, leagueId);
	}
	
	@RequestMapping(value = "/leagues/teams", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Team>> findTeams() {
		return new ResponseEntity<>(service.findTeams(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/teams", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Optional<Team>>> findTeamsByLeagueId(Integer leagueId) {
		return new ResponseEntity<>(service.findTeamsByLeagueId(leagueId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/leagues/{leagueId}/teams/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Optional<Team>> findTeamByLeagueIdAndId(Integer leagueId, Integer id) {
		return new ResponseEntity<>(service.findTeamByLeagueIdAndId(leagueId , id), HttpStatus.OK);
	}
}
