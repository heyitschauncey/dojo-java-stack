package com.saconverse.FullCrud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	@GetMapping("/superheros/{id}")
	public String superHeroInfo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("superHero", serv.getOne(id));
		
		return "superhero.jsp";
	}
	
	@GetMapping("/superheros/new")
	public String newSuperHero(@ModelAttribute("superHero") SuperHero superHero) {	
		return "newSuperHero.jsp";
	}
	
	@GetMapping("/superheros/{id}/edit")
	public String editSuperHero(@PathVariable("id") Long id, Model model) {
		model.addAttribute("superHero", serv.getOne(id));
		
		return "editSuperHero.jsp";
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
	
	@PutMapping("/superheros/{id}/update")
	public String updateSuperHero(@Valid @ModelAttribute("superHero") SuperHero superHero, BindingResult result) {
		System.out.println(superHero.getId());
		System.out.println(superHero.getName());
		System.out.println(superHero.getSuperPower());
		System.out.println(superHero.getWeakness());
		if	(result.hasErrors()) {
			return "editSuperHero.jsp";
		} else {
			serv.save(superHero);
			
			return "redirect:/superheros/" + superHero.getId();
		}
	}
	
	@DeleteMapping("/superheros/{id}/delete")
	public String deleteSuperHero(@PathVariable("id") Long id) {
		serv.delete(id);
		
		return "redirect:/superheros";
	}
}
