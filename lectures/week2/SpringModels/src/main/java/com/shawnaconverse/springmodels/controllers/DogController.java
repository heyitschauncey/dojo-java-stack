package com.shawnaconverse.springmodels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/dogs")
	public String dogs(Model model) {
		List<Dog> listOfDogs = dogServ.getAll();
		
		model.addAttribute("dogs", listOfDogs);
		
		
		return "index.jsp";
	}
}
