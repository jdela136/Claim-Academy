package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Pitch;

@Repository
public interface PitchRepository extends JpaRepository<Pitch, Integer>{

}
