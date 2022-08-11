package com.shawnaconverse.springmodels.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shawnaconverse.springmodels.models.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long>{
	List<Dog> findAll();
	
	List<Dog> findAllByHairColor(String hairColor);
}
