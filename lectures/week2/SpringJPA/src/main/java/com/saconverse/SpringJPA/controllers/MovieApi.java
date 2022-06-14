package com.saconverse.SpringJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saconverse.SpringJPA.models.Movie;
import com.saconverse.SpringJPA.services.MovieService;

@RestController
public class MovieApi {
//	private final MovieService movieService;
//	public MovieApi(MovieService m) {
//		this.movieService = m;
//	}
	
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/api/movies")
	public List<Movie> getAllMovies() {
		return movieService.findAll();
	}
	
	@PostMapping("/api/movies/create")
	public Movie createMovie(
			@RequestParam(value = "title") String title,
			@RequestParam(value = "genre") String genre,
			@RequestParam(value = "rating") Integer rating
			) {
//		Movie newMovie = new Movie(title, genre, rating);
		
//		return movieService.createMovie(newMovie);
		return movieService.createMovie(title, genre, rating);
	}
}
