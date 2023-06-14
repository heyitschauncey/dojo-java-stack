package com.shawnaconverse.fullcrud.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.shawnaconverse.fullcrud.models.Dog;
import com.shawnaconverse.fullcrud.services.DogService;

import jakarta.validation.Valid;

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
	
	@GetMapping("/dogs/new")
	public String newDogPage(@ModelAttribute("newDog") Dog dog) {
		// The @ModelAttribute annotation is a short hand for adding an attribute to the view model
		// this also automatically handles creating a dog object (or the data type of the param)
		return "newDog.jsp";
	}
	
	@GetMapping("/dogs/{id}/edit")
	public String editDogPage(@PathVariable("id") Long id, Model model) {
		Dog dogToEdit = serv.getOneDog(id);
		model.addAttribute("dogToEdit", dogToEdit);
		
		return "editDog.jsp";
	}
	
	
	// Equivalent function without @ModelAttribute
//	@GetMapping("/dogs/new")
//	public String newDogPage(Model model) {
//		model.addAttribute("newDog", new Dog());
//		return "newDog.jsp";
//	}
	
	
	@PostMapping("/dogs")
	public String createDog(@Valid @ModelAttribute("newDog") Dog dog, BindingResult result) {
		if (result.hasErrors()) {
			return "newDog.jsp";
		}

		serv.create(dog);
		
		return "redirect:/";
	}
	
	
	@PutMapping("/dogs/{id}")
	public String updateDog(@Valid @ModelAttribute("dogToEdit") Dog dog, 
		BindingResult result, Model model) {
		if (result.hasErrors()) {
			// return render the edit page
			// remember that data is not preserved from request to request
			// so any data we added to the view model needs to be added back
			model.addAttribute("dogToEdit");
			
			return "editDog.jsp";
		}
		
		serv.update(dog);
		
		return "redirect:/";
	}
	
	@DeleteMapping("/dogs/{id}")
	public String deleteDog(@PathVariable("id") Long id) {
		serv.deleteOneDog(id);
		
		return "redirect:/";
	}
	
}

















