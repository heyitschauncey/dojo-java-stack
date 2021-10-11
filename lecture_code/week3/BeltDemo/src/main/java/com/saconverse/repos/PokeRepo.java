package com.saconverse.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saconverse.models.Pokemon;

@Repository
public interface PokeRepo extends CrudRepository<Pokemon, Long> {
	List<Pokemon> findAll();
}
