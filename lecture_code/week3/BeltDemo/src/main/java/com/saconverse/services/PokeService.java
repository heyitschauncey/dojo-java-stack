package com.saconverse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saconverse.models.Pokemon;
import com.saconverse.repos.PokeRepo;

@Service
public class PokeService {
	@Autowired
	private PokeRepo pokeRepo;
	
	// ========== Create / Update ===============

	public Pokemon save(Pokemon p) {
		return pokeRepo.save(p);
	}

	// ========== Read ==========================

	public List<Pokemon> getAll() {
		return pokeRepo.findAll();
	}
	
	public Pokemon getOne(Long id) {
		Optional<Pokemon> optionalPoke = pokeRepo.findById(id);
		
		if (optionalPoke.isPresent()) {
			return optionalPoke.get();
		} else {
			return null;
		}
	}

	// ========== Delete ========================

	public void delete(Long id) {
		pokeRepo.deleteById(id);
	}
}
