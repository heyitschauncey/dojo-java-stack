package com.saconverse.FullCrud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saconverse.FullCrud.models.SideKick;
import com.saconverse.FullCrud.services.SideKickService;
import com.saconverse.FullCrud.services.SuperHeroService;

@Controller
public class SideKickController {
	
	@Autowired
	private SideKickService sideKickServ;
	
	@Autowired
	private SuperHeroService superHeroServ;
	
	// ========== Display =======================
	
	@GetMapping("/sidekicks/new")
	public String newSideKick(@ModelAttribute("sideKick") SideKick sideKick, Model model) {
		model.addAttribute("superHeros", superHeroServ.getAll());
		
		// model.addAttribute("sideKick", new SideKick());
		
		return "sidekicks/newSideKick.jsp";
	}
	
    // ========== Action ========================
	
	@PostMapping("/sidekicks/create")
	public String createSideKick(@Valid @ModelAttribute("sideKick") SideKick sideKick, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("superHeros", superHeroServ.getAll());
			
			return "sidekicks/newSideKick.jsp";
		} else {
//			System.out.println(sideKick.getName());
//			System.out.println(sideKick.getSuperPower());
//			System.out.println(sideKick.getWeakness());
//			System.out.println(sideKick.getSuperHero());
			sideKickServ.save(sideKick);
			
			return "redirect:/superheros";
		}
	}
	
}
