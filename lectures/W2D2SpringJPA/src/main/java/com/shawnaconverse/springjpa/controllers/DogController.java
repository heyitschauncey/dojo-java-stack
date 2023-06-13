package com.shawnaconverse.springjpa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shawnaconverse.springjpa.models.Dog;
import com.shawnaconverse.springjpa.services.DogService;

@Controller
public class DogController {
	private final DogService serv;
	
	public DogController(DogService s) {
		this.serv = s;
	}
	
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dog> listOfDogs = serv.getAllDogs();
		
		model.addAttribute("listOfDogs", listOfDogs);
		
		return "index.jsp";
 	}
}
