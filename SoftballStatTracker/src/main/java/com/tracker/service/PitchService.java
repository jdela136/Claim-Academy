package com.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.PitchRepository;

@Service
public class PitchService {
	
	@Autowired
	PitchRepository repository;
}
