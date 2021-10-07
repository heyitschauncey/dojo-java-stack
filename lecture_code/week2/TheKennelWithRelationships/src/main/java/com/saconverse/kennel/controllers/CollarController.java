package com.saconverse.kennel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saconverse.kennel.models.Collar;
import com.saconverse.kennel.services.CollarService;
import com.saconverse.kennel.services.DogService;

@Controller
public class CollarController {
	@Autowired
	private CollarService collarServ;
	
	@Autowired
	private DogService dogServ;
	
	// ========== Display =======================
	
	@GetMapping("/collars/new")
	public String newCollar(@ModelAttribute("collar") Collar collar, Model model) {
		model.addAttribute("allDogs", dogServ.getAll());
		
		return "collars/new_collar.jsp";
	}
	
    // ========== Action ========================
	
	@PostMapping("/collars/create")
	public String createCollar(@Valid @ModelAttribute("collar") Collar collar, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allDogs", dogServ.getAll());
			
			return "collars/new_collar.jsp";
		} else {
			collarServ.save(collar);
			
			return "redirect:/dashboard";
		}
	}
}
