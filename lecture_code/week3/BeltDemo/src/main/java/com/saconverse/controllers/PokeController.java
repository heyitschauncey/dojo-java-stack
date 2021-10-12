package com.saconverse.controllers;

import javax.servlet.http.HttpSession;
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
    
	// Read many
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("allPokemon", pokeServ.getAll());
		
		
		return "dashboard.jsp";
	}
	
	// Create
	@GetMapping("/pokemon/new")
	public String newPokemonForm(@ModelAttribute("newPokemon") Pokemon pokemon, Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
//		model.addAttribute("newPokemon", new Pokemon()); can use this instead of the @ModelAttribute param
		
		return "new_poke.jsp";
	}
	
	// Read One
	@GetMapping("/pokemon/{id}")
	public String displayPokemon(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("pokemon", pokeServ.getOne(id));
		
		
		return "display_pokemon.jsp";
	}
	
	// Update
	@GetMapping("/pokemon/{id}/edit")
	public String editPokemon(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		Pokemon pokemon = pokeServ.getOne(id);
		if (!session.getAttribute("uuid").equals(pokemon.getCreator().getId())) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("pokemon", pokemon);
		
		
		return "edit_poke.jsp";
	}
	
	// ========== Action ========================
	
	// Create
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
	
	// Update
	@PutMapping("/pokemon/{id}/update")
	public String updatePokemon(@Valid @ModelAttribute("pokemon") Pokemon pokeFromForm, BindingResult result, 
		HttpSession session, @PathVariable("id") Long id, Model model) {
		// redirects people not logged in to the login page
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		// checks if there are validation errors
		// if true, re-render the jsp page
		// if false update the pokemon in the database
		if (result.hasErrors()) {
			model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("uuid")));
//			model.addAttribute("pokemon", pokeServ.getOne(id));
			
			return "edit_poke.jsp";
		} else {
			Pokemon pokeFromDB = pokeServ.getOne(id);
			
			// this checks to make sure the logged in user is the creator of the pokemon
			if (!session.getAttribute("uuid").equals(pokeFromDB.getCreator().getId())) {
				return "redirect:/dashboard";
			}
			
			// we update the pokemon object from the DB with the data from the form
			pokeFromDB.setName(pokeFromForm.getName());
			pokeFromDB.setType(pokeFromForm.getType());
			pokeFromDB.setLevel(pokeFromForm.getLevel());
			
			// we save the pokemon object with the updated data to the DB
			pokeServ.save(pokeFromDB);
			
			return "redirect:/dashboard";
		}
	}
		
	// Delete
	@DeleteMapping("/pokemon/{id}/delete")
	public String deletePokemon(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		Pokemon p = pokeServ.getOne(id);
		// this checks to make sure the logged in user is the creator of the pokemon
		if (!session.getAttribute("uuid").equals(p.getCreator().getId())) {
			return "redirect:/dashboard";
		}
		
		pokeServ.delete(id);
		
		return "redirect:/dashboard";
	}
}
