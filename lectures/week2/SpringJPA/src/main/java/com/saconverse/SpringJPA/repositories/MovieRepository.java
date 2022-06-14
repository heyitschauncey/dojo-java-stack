package com.saconverse.SpringJPA.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saconverse.SpringJPA.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	List<Movie> findAll();
	
	List<Movie> findByTitleContainingOrderByTitleDesc(String title);
}
