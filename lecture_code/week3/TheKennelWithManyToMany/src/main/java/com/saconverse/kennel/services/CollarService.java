package com.saconverse.kennel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saconverse.kennel.models.Collar;
import com.saconverse.kennel.repos.CollarRepo;

@Service
public class CollarService {
	@Autowired
	private CollarRepo repo;
	
	// ========== Create / Update ===============

	public Collar save(Collar c) {
		return repo.save(c);
	}


	// ========== Read ==========================

	

	// ========== Delete ========================

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
