package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

}
