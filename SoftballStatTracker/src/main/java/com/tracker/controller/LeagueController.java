package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.LeagueService;

@CrossOrigin
@RestController
public class LeagueController {
	
	@Autowired
	LeagueService service;
}
