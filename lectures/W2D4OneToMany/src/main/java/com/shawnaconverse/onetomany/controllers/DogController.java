package com.shawnaconverse.onetomany.controllers;

import java.util.List;

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

import com.shawnaconverse.onetomany.models.Dog;
import com.shawnaconverse.onetomany.services.DogService;

import jakarta.validation.Valid;

@Controller
public class DogController {
	@Autowired
	private DogService serv;
	
	// Basic fundamental full crud app needs
	// 1. dashboard aka read all page
	// 2. single item aka read one page
	// 3. create page
	// 4. edit page
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dogs";
 	}
	
    // ========== Display =======================
	
	@GetMapping("/dogs")
	public String dashboard(Model model) {
		model.addAttribute("listOfDogs", serv.getAllDogs());
		
		return "dogs.jsp";
 	}

	@GetMapping("/dogs/{id}")
	public String oneDogPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneDog", serv.getOneDog(id));
		
		return "oneDog.jsp";
 	}
	
	@GetMapping("/dogs/new")
	public String newDogPage(@ModelAttribute("newDog") Dog dog) {
		return "newDog.jsp";
	}

	@GetMapping("/dogs/{id}/edit")
	public String editDogPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dogToEdit", serv.getOneDog(id));
		
		return "editDog.jsp";
	}
	
    // ========== Action ========================
	
	@PostMapping("/dogs")
	public String createDog(@Valid @ModelAttribute("newDog") Dog dog, BindingResult result) {
		if (result.hasErrors()) {
			return "newDog.jsp";
		}

		serv.save(dog);
		
		return "redirect:/dogs";
	}
	
	
	@PutMapping("/dogs/{id}")
	public String updateDog(@Valid @ModelAttribute("dogToEdit") Dog dog, 
		BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dogToEdit");
			
			return "editDog.jsp";
		}
		
		Dog editedDog = serv.save(dog);
		
		return "redirect:/dogs/" + editedDog.getId();
	}
	
	@DeleteMapping("/dogs/{id}")
	public String deleteDog(@PathVariable("id") Long id) {
		serv.deleteOneDog(id);
		
		return "redirect:/";
	}
	
}

















