package com.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository repository;
}