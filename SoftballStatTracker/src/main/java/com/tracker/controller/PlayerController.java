package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.PlayerService;

@CrossOrigin
@RestController
public class PlayerController {
	
	@Autowired
	PlayerService service;
}
