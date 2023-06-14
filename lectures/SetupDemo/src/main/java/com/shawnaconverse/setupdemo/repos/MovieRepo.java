package com.shawnaconverse.setupdemo.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shawnaconverse.setupdemo.models.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {
	List<Movie> findAll();
}
