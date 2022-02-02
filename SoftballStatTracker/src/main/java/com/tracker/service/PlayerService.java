package com.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository repository;
}
