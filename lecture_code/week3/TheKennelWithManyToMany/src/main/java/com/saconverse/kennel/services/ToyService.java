package com.saconverse.kennel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saconverse.kennel.models.Dog;
import com.saconverse.kennel.models.Toy;
import com.saconverse.kennel.repos.ToyRepo;

@Service
public class ToyService {
	@Autowired
	private ToyRepo repo;
	
	@Autowired
	private DogService dogService;
	
	// ========== Create / Update ===============

	public Toy save(Toy t) {
		return repo.save(t);
	}

	// ========== Read ==========================

	public List<Toy> getAll() {
		return repo.findAll();
	}
	
	public Toy getOne(Long id) {
		Optional<Toy> o = repo.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	// ========== Delete ========================

	public void delete(Long id) {
		repo.deleteById(id);
	}

	// ========== Relationships =================
	
	public Toy addToDog(Long toyId, Long dogId) {
		Toy toy = getOne(toyId);
		Dog dog = dogService.getOne(dogId);
		
		toy.getDogs().add(dog);
//		dog.getToys().add(toy);
		
		return save(toy);
	}
	
	public Toy removeFromDog(Long toyId, Long dogId) {
		Toy toy = getOne(toyId);
		Dog dog = dogService.getOne(dogId);
		
		toy.getDogs().remove(dog);
//		dog.getToys().remove(toy);
		
		return save(toy);
	}
}







