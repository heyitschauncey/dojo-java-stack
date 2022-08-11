package com.shawnaconverse.springmodels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shawnaconverse.springmodels.models.Toy;
import com.shawnaconverse.springmodels.services.DogService;
import com.shawnaconverse.springmodels.services.ToyService;

@Controller
@RequestMapping("/toys")
public class ToyController {
	@Autowired
	private ToyService toyServ;
	
	@Autowired
	private DogService dogServ;
	
	// ========== Display =======================
	
	@GetMapping("")
	public String allToys(@ModelAttribute("newToy") Toy newToy, Model model) {
		model.addAttribute("allToys", toyServ.getAll());
		model.addAttribute("allDogs", dogServ.getAll());
		
		return "toys/toys.jsp";
	}
	
    // ========== Action ========================
	
	
	@PostMapping("/create")
	public String createToy(@Valid @ModelAttribute("newToy") Toy newToy, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allToys", toyServ.getAll());
			model.addAttribute("allDogs", dogServ.getAll());
			
			return "toys/toys.jsp";
		}
//		System.out.println(newToy.getIsSqueaky());
		toyServ.save(newToy);
		
		return "redirect:/toys";
	}
	
}
