package com.shawnaconverse.springmodels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawnaconverse.springmodels.models.Toy;
import com.shawnaconverse.springmodels.repos.ToyRepo;

@Service
public class ToyService {
	@Autowired
	private ToyRepo toyRepo;
	
	// ========== Create / Update ===============

	public Toy save(Toy t) {
		return toyRepo.save(t);
	}

	// ========== Read ==========================

	public List<Toy> getAll() {
		return toyRepo.findAll();
	}
	
	// Main written out version of getOne()
//	public Toy getOne(Long id) {
//		Optional<Toy> toy = toyRepo.findById(id);
//		
//		if (toy.isPresent()) {
//			return toy.get();
//		} else {
//			return null;
//		}
//	}
	
	// Shorthand version
	public Toy getOne(Long id) {
		return toyRepo.findById(id).orElse(null);
	}

	// ========== Delete ========================
	
	public void delete(Long id) {
		toyRepo.deleteById(id);
	}
}
