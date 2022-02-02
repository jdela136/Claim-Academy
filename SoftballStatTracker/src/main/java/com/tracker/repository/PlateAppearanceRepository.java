package com.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.entity.PlateAppearance;

@Repository
public interface PlateAppearanceRepository extends JpaRepository<PlateAppearance, Integer>{

}
