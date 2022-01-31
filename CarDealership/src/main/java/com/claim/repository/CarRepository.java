package com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
