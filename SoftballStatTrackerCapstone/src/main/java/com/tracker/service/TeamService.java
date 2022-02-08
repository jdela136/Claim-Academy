package com.tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracker.entity.League;
import com.tracker.entity.Team;
import com.tracker.repository.LeagueRepository;
import com.tracker.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	LeagueRepository leagueRepository;
	
	public void addTeam(Team team, Integer leagueId) {
		League league =  leagueRepository.findById(leagueId).get();
		team.setLeague(league);
		team.setWins(0);
		team.setLosses(0);
		teamRepository.save(team);
	}
	
	public List<Team> findTeams() {
		return teamRepository.findAll();
	}
	
	public List<Optional<Team>> findTeamsByLeagueId(Integer leagueId) {
		return teamRepository.findTeamByLeagueId(leagueId);
	}
	
	public Optional<Team> findTeamByLeagueIdAndId(Integer leagueId, Integer id) {
		return teamRepository.findTeamByLeagueIdAndId(leagueId, id);
	}
}
