package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.TeamService;

@CrossOrigin
@RestController
public class TeamController {
	
	@Autowired
	TeamService service;
}
