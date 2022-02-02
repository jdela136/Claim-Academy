package com.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.repository.PlateAppearanceRepository;

@Service
public class PlateAppearanceService {
	
	@Autowired
	PlateAppearanceRepository repository;
}
