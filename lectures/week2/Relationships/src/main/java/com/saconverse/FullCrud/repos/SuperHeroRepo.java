package com.saconverse.FullCrud.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saconverse.FullCrud.models.SuperHero;

@Repository
public interface SuperHeroRepo extends CrudRepository<SuperHero, Long> {
	List<SuperHero> findAll();
}
