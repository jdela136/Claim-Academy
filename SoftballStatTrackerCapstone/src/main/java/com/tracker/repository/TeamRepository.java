package com.tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
//	@Query("SELECT T FROM Team T WHERE T.teamName = ?1")
//	public Team findTeamByName(String name);
	
	@Query("SELECT T FROM Team T WHERE T.league.id = ?1")
	public List<Optional<Team>> findTeamByLeagueId(Integer leagueId);
	
	@Query("SELECT T FROM Team T WHERE T.league.id = ?1 AND T.id = ?2")
	public Optional<Team> findTeamByLeagueIdAndId(Integer leagueId, Integer id);
}
