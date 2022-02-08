package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer>{

}
