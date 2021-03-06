package com.claim.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.entity.Car;
import com.claim.entity.Inventory;
import com.claim.entity.Sale;
import com.claim.repository.CarRepository;
import com.claim.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	CarRepository carRepository;
	
	public void inventoryAdd(Inventory inventory) {
		List<Car> cars = carRepository.findAll();
		for(Car car: cars) {
			if(car.getMake().equals(inventory.getCar().getMake()) 
					&& car.getModel().equals(inventory.getCar().getModel())
					&& car.getYear().equals(inventory.getCar().getYear())) {
				inventory.setCar(car);
			}
		}
		if(inventory.getPurchaseDate().isBefore(LocalDate.now().minusDays(120))) {
			inventory.setIsBiddable(true);
		}
		else {
			inventory.setIsBiddable(false);
		}
		inventoryRepository.save(inventory);
	}
	
	public Inventory getInventoryCarbyId(Integer id) {
		return inventoryRepository.getInventoryCarbyId(id);
	}
	
	public List<Inventory> getInventory() {
		List<Inventory> inventory = inventoryRepository.findAll();
		List<Inventory> temp = new ArrayList<Inventory>();
		for(Inventory car : inventory) {
			if(car.getSale() == null) {
				temp.add(car);
			}
		}
		return temp;
	}
	
	public List<Inventory> getInventoryCarsbyModel(String model) {
		List<Inventory> inventory = inventoryRepository.findAll();
		List<Inventory> temp = new ArrayList<Inventory>();
		for(Inventory car : inventory) {
			if(car.getSale() == null && car.getCar().getModel().equals(model)) {
				temp.add(car);
			}
		}
		return temp;
	}
	
	public void bid(Double bid, Integer id) {
		Inventory car = getInventoryCarbyId(id);
		Double max = car.getPrice() - (car.getPrice() * .1);
		if(car.getIsBiddable()){
			if(bid > max) {
				car.setPrice(bid);
				inventoryRepository.save(car);
			}
		}
	}
	
	public void addSale(Sale sale, Integer id) {
		Inventory car = getInventoryCarbyId(id);
		car.setSale(sale);
		car.getSale().setPurchaseDate(LocalDate.now());
		inventoryRepository.save(car);
	}
	
	public List<Inventory> getSales() {
		List<Inventory> inventory = inventoryRepository.findAll();
		List<Inventory> temp = new ArrayList<Inventory>();
		for(Inventory car : inventory) {
			if(car.getSale() != null) {
				temp.add(car);
			}
		}
		return temp;
	}
}
