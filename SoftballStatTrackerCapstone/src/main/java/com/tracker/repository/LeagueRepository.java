package com.tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer>{
	
	
	@Query("SELECT L FROM League L WHERE L.commissioner.email = ?1")
	public Optional<League> getLeagueByCommisionerEmail(String email);
}
