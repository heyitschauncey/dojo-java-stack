package com.shawnaconverse.fullcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shawnaconverse.fullcrud.models.Dog;
import com.shawnaconverse.fullcrud.repos.DogRepository;

@Service
public class DogService {
	// member variable to hold an instance of our repository
	private final DogRepository dogRepo;
	
	// Constructor will instantiate our dogRepo object for us
	public DogService(DogRepository dogRepo) {
		this.dogRepo = dogRepo;
	}
	
	// ========== Create / Update ===============

	public Dog create(Dog d) {
		// save returns an object of type Dog
		// data inside of the object is the data from the database
		// will now include the id, createdAt, updatedAt
		return dogRepo.save(d);
	}

	public Dog update(Dog d) {
		// save returns an object of type Dog
		// data inside of the object is the data from the database
		// will now include the id, createdAt, updatedAt
		return dogRepo.save(d);
	}
	
//	public Dog save(Dog d) {
//		// save returns an object of type Dog
//		// data inside of the object is the data from the database
//		// will now include the id, createdAt, updatedAt
//		return dogRepo.save(d);
//	}
	// ========== Read ==========================

	public List<Dog> getAllDogs() {
		return dogRepo.findAll();
	}
	
	public Dog getOneDog(Long id) {
		Optional<Dog> optDog = dogRepo.findById(id);
		
		if (optDog.isPresent()) {
			return optDog.get();
		} else {
			return null;
		}
	}

	// ========== Delete ========================

	public void deleteOneDog(Long id) {
		dogRepo.deleteById(id);
	}

	// ========== Relationships =================

}

