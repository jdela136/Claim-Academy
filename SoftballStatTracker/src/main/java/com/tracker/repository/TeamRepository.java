package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}
