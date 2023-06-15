package com.shawnaconverse.onetomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shawnaconverse.onetomany.models.Collar;
import com.shawnaconverse.onetomany.services.CollarService;
import com.shawnaconverse.onetomany.services.DogService;

import jakarta.validation.Valid;

@Controller
public class CollarController {
	@Autowired
	private CollarService cServ;
	
	@Autowired
	private DogService dServ;
	
	
	// ========== Display =======================
	
	@GetMapping("/collars/new")
	public String newCollarPage(@ModelAttribute("newCollar") Collar collar, Model model) {
		model.addAttribute("listOfDogs", dServ.getAllDogs());
		
		return "collars/newCollar.jsp";
	}
	
//	@GetMapping("/collars/new")
//	public String newCollarPage(Model model) {
//		model.addAttribute("listOfDogs", dServ.getAllDogs());
//		model.addAttribute("newCollar", new Collar());
//		
//		return "newCollar.jsp";
//	}

    // ========== Action ========================
	
	@PostMapping("/collars")
	public String createCollar(@Valid @ModelAttribute("newCollar") Collar collar, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("listOfDogs", dServ.getAllDogs());

			return "collars/newCollar.jsp";
		}
		
		Collar newCollar = cServ.save(collar);
		
		return "redirect:/dogs/" + newCollar.getDog().getId();
	}
	
	@DeleteMapping("/collars/{id}/{dogid}")
	public String deleteOneCollar(@PathVariable("id") Long id, @PathVariable("dogid") Long dogId) {
		cServ.deleteOneCollar(id);
		
		return "redirect:/dogs/" + dogId;
	}
	
//	@DeleteMapping("/collars/{id}")
//	public String deleteOneCollar(@PathVariable("id") Long id) {
//		Collar collar = cServ.getOneCollar(id);
//		cServ.deleteOneCollar(id);
//		
//		return "redirect:/dogs/" + collar.getDog().getId();
//	}
	
	
	
	
	
	
	
}
