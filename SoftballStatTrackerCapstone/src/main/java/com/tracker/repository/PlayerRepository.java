package com.tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

	@Query("SELECT P FROM Player P WHERE P.firstName = ?1 AND P.lastName = ?2")
	public Optional<Player> getPlayerByFirstAndLast(String first, String last);
	
	@Query("SELECT P FROM Player P WHERE P.team.id = ?1 AND P.lineupId = ?2 ORDER BY P.lineupId ASC")
	public Optional<Player> findTopPlayerByTeamIdAndLineUpId(Integer teamId, Integer lineupId);
	
	@Query("SELECT P FROM Player P WHERE P.team.id = ?1 ORDER BY P.lineupId")
	public Optional<List<Player>> findLineUp(Integer teamId);

//	public void findTopByOrderByTe();
}
