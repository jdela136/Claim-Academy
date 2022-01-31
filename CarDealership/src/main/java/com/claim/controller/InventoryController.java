package com.claim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.claim.entity.Inventory;
import com.claim.service.InventoryService;

@Controller
public class InventoryController {
	
	@Autowired
	InventoryService service;
	
	@GetMapping("/")
	public ModelAndView welcome(Model model) {
		List<Inventory> cars = service.getInventory();
		model.addAttribute("cars", cars);
		return new ModelAndView("inventory", "model", new Inventory());
	}
	
	@GetMapping("/add-to-inventory")
	public ModelAndView inventoryAdd(Model model) {
		return new ModelAndView("add-to-inventory", "inventoryCar", new Inventory());
	}
	
	@PostMapping("/add-to-inventory")
	public String handleInventoryAdd(Model model, @ModelAttribute("inventoryCar") Inventory car, HttpSession session) {
		
		service.inventoryAdd(car);
		model.addAttribute("newCar", car);
		return "success";
	}
	
	
	@GetMapping("/inventory-car/{id}")
	public ModelAndView showCarDetails(Model model, @PathVariable Integer id, HttpSession session) {
		Inventory inventoryCar = service.getInventoryCarbyId(id);
		model.addAttribute("car", inventoryCar);
		return new ModelAndView("/inventory-car", "inventoryCar", new Inventory());
	}
	
	@PutMapping("/inventory-car/{id}")
	public String bid(Model model, @ModelAttribute("inventoryCar") Inventory car, HttpSession session, @PathVariable Integer id) {
		service.bid(car.getPrice(), id);
		return "/inventory-car/{id}";
	}
	
	@PostMapping("/inventory")
	public String showCarsByModel(Model model, @ModelAttribute("model") Inventory car, HttpSession session) {
		List<Inventory> cars = service.getInventoryCarsbyModel(car.getCar().getModel());
		model.addAttribute("cars", cars);
		return "show-cars-by-model";
	}
	
	
}
