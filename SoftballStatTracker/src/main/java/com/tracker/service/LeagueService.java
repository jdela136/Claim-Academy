package com.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.LeagueRepository;

@Service
public class LeagueService {
	
	@Autowired
	LeagueRepository repository;
}
