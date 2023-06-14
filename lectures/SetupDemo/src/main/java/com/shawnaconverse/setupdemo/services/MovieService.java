package com.shawnaconverse.setupdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawnaconverse.setupdemo.models.Movie;
import com.shawnaconverse.setupdemo.repos.MovieRepo;

@Service
public class MovieService {
	// instantiates a movie repo object so we can preform crud queries
//	private final MovieRepo repo;
//	
//	public MovieService(MovieRepo repo) {
//		this.repo = repo;
//	}
	
	// shorthand for the above
	@Autowired
	private MovieRepo repo;
	
	
	// ========== Create / Update ===============

	public Movie save(Movie m) {
		return repo.save(m);
	}

	// ========== Read ==========================

	public List<Movie> getAllMovies() {
		return repo.findAll();
	}
	
	public Movie getOneMovie(Long id) {
		Optional<Movie> optMovie = repo.findById(id);
		
		if (optMovie.isPresent()) {
			return optMovie.get();
		} else {
			return null;
		}
	}

	// ========== Delete ========================

	public void deleteOneMovie(Long id) {
		repo.deleteById(id);
	}

}
