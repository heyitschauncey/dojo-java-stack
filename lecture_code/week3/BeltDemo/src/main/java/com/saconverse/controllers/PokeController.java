package com.saconverse.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saconverse.models.Pokemon;
import com.saconverse.models.User;
import com.saconverse.services.PokeService;
import com.saconverse.services.UserService;

@Controller
public class PokeController {
	@Autowired
	private PokeService pokeServ;
	
	@Autowired
	private UserService userServ;
	
	// ========== Display =======================
    
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
		
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/pokemon/new")
	public String newPokemonForm(@ModelAttribute("newPokemon") Pokemon pokemon, Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
//		model.addAttribute("newPokemon", new Pokemon()); can use this instead of the @ModelAttribute param
		
		return "new_poke.jsp";
	}
	
	// ========== Action ========================
	
	@PostMapping("/pokemon/create")
	public String createPokemon(@Valid @ModelAttribute("newPokemon") Pokemon pokemon, BindingResult result, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			
			return "new_poke.jsp";
		}
		
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		pokemon.setCreator(user);
		
		pokeServ.save(pokemon);
		
		return "redirect:/dashboard";
	}
	
}
