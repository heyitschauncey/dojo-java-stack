package com.saconverse.kennel.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saconverse.kennel.models.Dog;

@Repository
public interface DogRepo extends CrudRepository<Dog, Long> {
	List<Dog> findAll();
}
