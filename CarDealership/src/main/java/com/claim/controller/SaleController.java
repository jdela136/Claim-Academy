package com.claim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.claim.entity.Sale;
import com.claim.service.SaleService;

@Controller
public class SaleController {

	@Autowired
	SaleService service;
	
//	@GetMapping("/display-sales")
//	public String displaySales(Model model) {
//		List<Sale> sales = service.getSales();
//		model.addAttribute("sales", sales);
//		return "display-sales";
//	}
}
