package com.saconverse.FullCrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saconverse.FullCrud.models.SuperHero;
import com.saconverse.FullCrud.repos.SuperHeroRepo;

@Service
public class SuperHeroService {
//	private final SuperHeroRepo superRepo;
//	
//	public SuperHeroService(SuperHeroRepo repo) {
//		this.superRepo = repo;
//	}
	
	@Autowired
	private SuperHeroRepo superRepo;
	
	// ========== Create / Update ===============

	public SuperHero save(SuperHero s) {
		return superRepo.save(s);
	}

	// ========== Read ==========================

	public List<SuperHero> getAll() {
		return superRepo.findAll();
	}
	
	public SuperHero getOne(Long id) {
		Optional<SuperHero> optHero = superRepo.findById(id);
		
		if (optHero.isPresent()) {
			return optHero.get();
		} else {
			return null;
		}
	}

	// ========== Delete ========================
	
	public void delete(Long id) {
		superRepo.deleteById(id);
	}
}
