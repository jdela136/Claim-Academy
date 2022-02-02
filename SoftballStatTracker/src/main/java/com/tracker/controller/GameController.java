package com.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.service.GameService;

@CrossOrigin
@RestController
public class GameController {
	
	@Autowired
	GameService service;
}
