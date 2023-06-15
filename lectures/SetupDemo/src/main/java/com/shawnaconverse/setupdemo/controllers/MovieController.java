package com.shawnaconverse.setupdemo.controllers;

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

import com.shawnaconverse.setupdemo.models.Movie;
import com.shawnaconverse.setupdemo.services.MovieService;

import jakarta.validation.Valid;

@Controller
public class MovieController {
	@Autowired
	private MovieService serv;

	// Basic fundamental full crud app needs
	// 1. dashboard aka read all page
	// 2. single item aka read one page
	// 3. create page
	// 4. edit page
	
	@GetMapping("/")
	public String index() {
		return "redirect:/movies";
	}
	
	
	// ========== Display =======================
	// GET requests
	// what renders pages
	
	@GetMapping("/movies")
	public String dashboard(Model model) {
		model.addAttribute("listOfMovies", serv.getAllMovies());

		return "movies.jsp";
	}

	@GetMapping("/movies/{id}")
	public String oneMoviePage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneMovie", serv.getOneMovie(id));
		
		return "oneMovie.jsp";
	}

	@GetMapping("/movies/new")
	public String createPage(@ModelAttribute("newMovie") Movie movie) {
		return "newMovie.jsp";
	}
	
	@GetMapping("/movies/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("movieToEdit", serv.getOneMovie(id));
		
		return "editMovie.jsp";
	}
	
    // ========== Action ========================
	// POST, PUT, DELETE requests
	// perform an action then redirect
	
	@PostMapping("/movies")
	public String createMovie(@Valid @ModelAttribute("newMovie") Movie movie, BindingResult result) {
		if (result.hasErrors()) {
			return "newMovie.jsp";
		}
		
		serv.save(movie);
		
		return "redirect:/movies";
	}
	
	
	// very important this path variable is specifically called id
	// spring does some behind the scenes if it is called id that we want
	@PutMapping("/movies/{id}")
	public String updateMovie(@Valid @ModelAttribute("movieToEdit") Movie movie, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("movieToEdit", movie);
			
			return "editMovie.jsp";
		}
//		return "redirect:/movies";
		
		Movie editedMovie = serv.save(movie);
		return "redirect:/movies/" + editedMovie.getId();
	}
	
	
	@DeleteMapping("/movies/{id}")
	public String deleteMovie(@PathVariable("id") Long id) {
		serv.deleteOneMovie(id);
		
		return "redirect:/movies";
	}
	
}




























