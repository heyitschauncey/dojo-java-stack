package com.saconverse.SpringJPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saconverse.SpringJPA.models.Movie;
import com.saconverse.SpringJPA.repositories.MovieRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepo;
	
	public MovieService(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}
	
	// CREATE
	
	public Movie createMovie(Movie m) {
		return movieRepo.save(m);
	}
	
	// READ
	
	public List<Movie> findAll() {
		return movieRepo.findAll();
	}
	
	public Movie findOne(Long id) {
		Optional<Movie> optionalMovie = movieRepo.findById(id);
		
		if (optionalMovie.isPresent()) {
			return optionalMovie.get();
		} else {
			return null;
		}
	}
}
