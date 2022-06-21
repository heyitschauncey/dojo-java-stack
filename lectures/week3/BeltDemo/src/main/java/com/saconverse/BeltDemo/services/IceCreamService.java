package com.saconverse.BeltDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saconverse.BeltDemo.models.IceCream;
import com.saconverse.BeltDemo.repos.IceCreamRepo;

@Service
public class IceCreamService {
	@Autowired
	private IceCreamRepo iceCreamRepo;
	
	// ========== Create / Update ===============

	public IceCream save(IceCream c) {
		return iceCreamRepo.save(c);
	}

	// ========== Read ==========================

	public List<IceCream> getAll() {
		return iceCreamRepo.findAll();
	}
	
	public IceCream getOne(Long id) {
		return iceCreamRepo.findById(id).orElse(null);
	}
	
//	public IceCream getOne(Long id) {
//		Optional<IceCream> optIceCream = iceCreamRepo.findById(id);
//		
//		if (optIceCream.isPresent()) {
//			return optIceCream.get();
//		} else {
//			return null;
//		}
//	}

	// ========== Delete ========================
	
	public void delete(Long id) {
		iceCreamRepo.deleteById(id);
	}
}
