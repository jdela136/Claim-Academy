package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tracker.entity.League;
import com.tracker.repository.LeagueRepository;

@Service
public class LeagueService {
	
	@Autowired
	LeagueRepository repository;
	
	public void startLeague(League league) {
		repository.save(league);
	}
	
	public List<League> findLeagues() {
		return repository.findAll();
	}
}
