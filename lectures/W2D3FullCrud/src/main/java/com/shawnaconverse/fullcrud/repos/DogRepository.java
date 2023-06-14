package com.shawnaconverse.fullcrud.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shawnaconverse.fullcrud.models.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
	List<Dog> findAll();

}
