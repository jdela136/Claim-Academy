package com.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository repository;
}
