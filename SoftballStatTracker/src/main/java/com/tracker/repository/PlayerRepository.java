package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
