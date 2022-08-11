package com.shawnaconverse.springmodels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawnaconverse.springmodels.models.Dog;
import com.shawnaconverse.springmodels.repos.DogRepository;

@Service
public class DogService {
//	private final DogRepository dogRepo;
//	
//	public DogService(DogRepository dogRepo) {
//		this.dogRepo = dogRepo;
//	}
//	
	@Autowired
	private DogRepository dogRepo;
	
	// ========== Create / Update ===============

	public Dog save(Dog dog) {
		return dogRepo.save(dog);
	}

	// ========== Read ==========================
	
	public List<Dog> getAll() {
		return dogRepo.findAll();
	}
	
	public Dog getOne(Long id) {
		Optional<Dog> optDog = dogRepo.findById(id);
		
		if (optDog.isPresent()) {
			return optDog.get();
		} else {
			return null;
		}
	}
	
	// ========== Delete ========================
	
	public void delete(Long id) {
		dogRepo.deleteById(id);
	}
	
}
