package com.shawnaconverse.springmodels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shawnaconverse.springmodels.models.Dog;
import com.shawnaconverse.springmodels.services.DogService;

@Controller
public class DogController {
	//	private final DogService dogServ;
	//	public DogController(DogService ds) {
	//		this.dogServ = ds;
	//	}
	
	// this will instantiate the service object and put it in the member variable for us
	// this is short hand for the steps above
	// we do not use the final keyword
	@Autowired
	private DogService dogServ;
	
	
	// RESTful Routing Style
	// all routes, in general, take  certain structure
	// /<table_name>/action
	// /api/<table_name>/action
	@GetMapping("/")
	public String index() {
		return "redirect:/dogs";
	}
	
	// ========== Display =======================
	
	@GetMapping("/dogs")
	public String dogs(Model model) {
		List<Dog> listOfDogs = dogServ.getAll();
		
		model.addAttribute("dogs", listOfDogs);
		
		return "index.jsp";
	}
	
	@GetMapping("/dogs/new")
	public String newDog(@ModelAttribute("newDog") Dog newDog) {
		// creating an empty Dog object and passing it to the jsp page
		// if we were using Model model, the equivalent code would be
		// model.addAttribute("newDog", new Dog());
		
		
		return "newDog.jsp";
	}
	
	// ========== Action ========================
	
	@PostMapping("/dogs/create")
	public String createDog(@Valid @ModelAttribute("newDog") Dog newDog, BindingResult result) {
		// this newDog parameter is going to contain a Dog object with all the post data from the form
		if (result.hasErrors()) {
			return "newDog.jsp";
		}
		
		dogServ.save(newDog);
		
		return "redirect:/dogs";
	}
	
	
}









