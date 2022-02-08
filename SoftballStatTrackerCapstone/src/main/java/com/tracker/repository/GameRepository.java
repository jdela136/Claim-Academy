package com.tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{
	
//	@Query("SELECT G FROM Game G ORDER BY G.id DESC")
//	public Game getLastGame();
}
