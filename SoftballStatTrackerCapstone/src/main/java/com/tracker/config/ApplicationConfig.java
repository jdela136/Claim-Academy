package com.tracker.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.tracker.repository")
@EntityScan(basePackages="com.tracker.entity")
public class ApplicationConfig {
	
}

