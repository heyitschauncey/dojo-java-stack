package com.saconverse.FullCrud.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saconverse.FullCrud.models.SideKick;

@Repository
public interface SideKickRepo extends CrudRepository<SideKick, Long> {
	List<SideKick> findAll();
}
