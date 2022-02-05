package com.tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.entity.PlateAppearance;
import com.tracker.entity.Player;

@Repository
public interface PlateAppearanceRepository extends JpaRepository<PlateAppearance, Integer>{
	
//	@Query("SELECT P FROM PlateAppearance P WHERE P.game.id = ?1 ORDER BY P.id DESC")
//	public Optional<PlateAppearance> findTopPlateAppearanceByGameId(Integer gameId);

//	@Query("SELECT P FROM PlateAppearance P WHERE P.game.id = ?1 ORDER BY P.id DESC")
//	public Optional<PlateAppearance> getlastPAByGameId(Integer gameId);
	
	@Query("SELECT P FROM PlateAppearance P WHERE P.game.id = ?1 ORDER BY P.id DESC")
	public Optional<List<PlateAppearance>> getPAsByGameIdDesc(Integer gameId);
	
	@Query("SELECT P FROM PlateAppearance P WHERE P.game.id = ?1")
	public Optional<List<PlateAppearance>> getPAsByGameId(Integer gameId);
	
	@Query("SELECT P FROM PlateAppearance P WHERE P.game.id = ?1 AND P.base = ?2")
	public Optional<List<PlateAppearance>> getPAByBase(Integer gameId, Integer base);
	
	@Query("SELECT P FROM PlateAppearance P WHERE P.base != 5 OR P.base != 4 AND P.base IS NOT NULL AND P.game.id = ?1 ORDER BY P.base DESC")
	public Optional<List<PlateAppearance>> getPAsOnBase(Integer gameId);
}
