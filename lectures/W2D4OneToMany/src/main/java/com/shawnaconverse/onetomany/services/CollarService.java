package com.shawnaconverse.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawnaconverse.onetomany.models.Collar;
import com.shawnaconverse.onetomany.repos.CollarRepo;

@Service
public class CollarService {
	@Autowired
	private CollarRepo repo;
	
	// ========== Create / Update ===============

	public Collar save(Collar c) {
		return repo.save(c);
	}

	// ========== Read ==========================


	public List<Collar> getAllCollars() {
		return repo.findAll();
	}
	

	public Collar getOneCollar(Long id) {
		return repo.findById(id).orElse(null);
	}

	// ========== Delete ========================
	
	public void deleteOneCollar(Long id) {
		repo.deleteById(id);
	}
}
