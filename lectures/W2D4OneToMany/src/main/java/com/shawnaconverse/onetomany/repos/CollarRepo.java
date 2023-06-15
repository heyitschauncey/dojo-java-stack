package com.shawnaconverse.onetomany.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shawnaconverse.onetomany.models.Collar;

@Repository
public interface CollarRepo extends CrudRepository<Collar, Long> {
	List<Collar> findAll();
}
