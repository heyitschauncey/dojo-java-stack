package com.saconverse.FullCrud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saconverse.FullCrud.models.SuperHero;
import com.saconverse.FullCrud.services.SuperHeroService;

@Controller
public class SuperHeroController {
	
	@Autowired
	private SuperHeroService serv;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/superheros";
	}
	
	// ========== Display =======================
	
	@GetMapping("/superheros")
	public String superHeros(Model model) {
		model.addAttribute("superHeros", serv.getAll());
		
		return "superheros.jsp";
	}
	
	@GetMapping("/superheros/new")
	public String newSuperHero(@ModelAttribute("superHero") SuperHero superHero) {	
		return "newSuperHero.jsp";
	}
	
	// ========== Action ========================
	
	@PostMapping("/superheros/create")
	public String createSuperHero(@Valid @ModelAttribute("superHero") SuperHero superHero, BindingResult result) {
		if	(result.hasErrors()) {
			return "newSuperHero.jsp";
		} else {
			serv.save(superHero);
			
			return "redirect:/superheros";
		}
	}
	
}
