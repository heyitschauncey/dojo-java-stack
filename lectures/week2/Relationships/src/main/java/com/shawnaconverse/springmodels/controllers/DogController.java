package com.shawnaconverse.springmodels.controllers;

import java.util.List;

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
	
	// FULL CRUD example routes
//	/dogs
//	/dogs/new
//	/dogs/create
//	/dogs/{id}
//	/dogs/{id}/edit
//	/dogs/{id}/update
//	/dogs/{id}/delete
	
	
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dogs";
	}
	
	// ========== Display =======================
	
	@GetMapping("/dogs")
	public String dogs(Model model) {
		List<Dog> listOfDogs = dogServ.getAll();
		
		model.addAttribute("dogs", listOfDogs);
		
		return "dogs/index.jsp";
	}
	
	@GetMapping("/dogs/new")
	public String newDog(@ModelAttribute("newDog") Dog newDog) {
		// creating an empty Dog object and passing it to the jsp page
		// if we were using Model model, the equivalent code would be
		// model.addAttribute("newDog", new Dog());
		
		return "dogs/newDog.jsp";
	}
	
	@GetMapping("/dogs/{id}")
	public String oneDog(@PathVariable("id") Long id, Model model) {
//		Dog thisDog = dogServ.getOne(id);
//		model.addAttribute("dog", thisDog);
		
		model.addAttribute("dog", dogServ.getOne(id));
		
		return "dogs/oneDog.jsp";
	}
	
	@GetMapping("/dogs/{id}/edit")
	public String editDog(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dog", dogServ.getOne(id));
		
		return "dogs/editDog.jsp";
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
	
	@PutMapping("/dogs/{id}/update")
	public String updateDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, @PathVariable("id") Long dogId) {
		if (result.hasErrors()) {
			return "editDog.jsp";
		}
		System.out.println("The dog id in the model attribute is:" + dog.getId());
		
//		dog.setId(dogId);
		dogServ.save(dog);
		
//		return "redirect:/dogs/" + id;
		return String.format("redirect:/dogs/%d", dogId);
	}
	
	@DeleteMapping("/dogs/{id}/delete")
	public String deleteDog(@PathVariable("id") Long id) {
		dogServ.delete(id);
		
		return "redirect:/dogs";
	}
	
}









