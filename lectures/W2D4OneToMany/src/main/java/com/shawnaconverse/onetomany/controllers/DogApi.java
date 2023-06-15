package com.shawnaconverse.onetomany.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shawnaconverse.onetomany.models.Dog;
import com.shawnaconverse.onetomany.services.DogService;

@RestController
public class DogApi {
	private final DogService serv;
	
	public DogApi(DogService s) {
		this.serv = s;
	}
	
	
//	@RequestMapping("/") // GET request to the index route
//	@RequestMapping("/", method = RequestMethod.POST) // POST request to the index route
	// Short hands
//	@GetMapping("/")
//	@PostMapping("/")
	
	@GetMapping("/api/dogs")
	public List<Dog> allDogs() {
		return serv.getAllDogs();
	}
	
	@GetMapping("/api/dogs/{id}")
	public Dog oneDog(@PathVariable("id") Long id) {
		Dog d = serv.getOneDog(id);
		
		return d;
	}
	
	
	@PostMapping("/api/dogs")
	public Dog createDog(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age,
			@RequestParam(value = "hairColor") String hairColor) {
		Dog d = new Dog(name, age, hairColor);
		
		return serv.save(d);
	}
}
