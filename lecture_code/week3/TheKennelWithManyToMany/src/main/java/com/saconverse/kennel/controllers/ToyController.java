package com.saconverse.kennel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saconverse.kennel.models.Toy;
import com.saconverse.kennel.services.ToyService;

@Controller
public class ToyController {
	@Autowired
	private ToyService tServ;
	
	@GetMapping("/toys")
	public String allToys(Model model) {
		model.addAttribute("allToys", tServ.getAll());
		model.addAttribute("toy", new Toy());
		
		return "toys/toys.jsp";
	}
	
	
	@PostMapping("/toys/create")
	public String createToy(@ModelAttribute("toy") Toy toy) {
		tServ.save(toy);
		
		return "redirect:/toys";
	}
}
