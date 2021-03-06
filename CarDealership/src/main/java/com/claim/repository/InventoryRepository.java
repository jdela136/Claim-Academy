package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.*;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	@Query("Select I FROM Inventory I WHERE I.id = ?1")
	public Inventory getInventoryCarbyId(Integer id);
	
	
}
