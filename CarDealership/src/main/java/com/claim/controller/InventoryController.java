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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.claim.entity.Inventory;
import com.claim.entity.Sale;
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
	public ModelAndView showCarDetails(Model model, @PathVariable("id") Integer id, HttpSession session) {
		Inventory inventoryCar = service.getInventoryCarbyId(id);
		model.addAttribute("car", inventoryCar);
		return new ModelAndView("/inventory-car", "inventoryCar", new Inventory());
	}
	
	@PostMapping("/inventory-car/{id}")
	public ModelAndView bid(Model model, @ModelAttribute("inventoryCar") Inventory car, HttpSession session, @PathVariable("id") Integer id) {
		Inventory inventoryCar = service.getInventoryCarbyId(id);
		service.bid(car.getPrice(), id);
		model.addAttribute("car", inventoryCar);
		return new ModelAndView("/inventory-car", "inventoryCar", new Inventory());
	}
	
	@PostMapping("/inventory")
	public String showCarsByModel(Model model, @ModelAttribute("model") Inventory car, HttpSession session) {
		List<Inventory> cars = service.getInventoryCarsbyModel(car.getCar().getModel());
		model.addAttribute("cars", cars);
		return "show-cars-by-model";
	}
	
	@GetMapping("/sell-car/{id}")
	public ModelAndView sale(Model model, @PathVariable("id") Integer id) {
		//Inventory inventoryCar = service.getInventoryCarbyId(id);
		model.addAttribute("id", id);
		return new ModelAndView("sell-car", "sale", new Sale());
	}
	
	@PostMapping("/sell-car/{id}")
	public String handleSale(Model model, @ModelAttribute("sale") Sale sale, HttpSession session, @PathVariable("id") Integer id) {	
		Inventory inventoryCar = service.getInventoryCarbyId(id);
		service.addSale(sale, id);
		model.addAttribute("soldCar", inventoryCar);
		return "sale-success";
	}
	
	@GetMapping("/display-sales")
	public String displaySales(Model model) {
		List<Inventory> sales = service.getSales();
		model.addAttribute("sales", sales);
		return "display-sales";
	}
}
