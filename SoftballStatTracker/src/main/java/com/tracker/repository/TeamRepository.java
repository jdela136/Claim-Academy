package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	@Query("SELECT T FROM Team T WHERE T.teamName = ?1")
	public Team findTeamByName(String name);
}
