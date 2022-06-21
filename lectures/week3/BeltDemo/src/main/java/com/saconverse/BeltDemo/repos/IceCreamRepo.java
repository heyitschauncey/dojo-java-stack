package com.saconverse.BeltDemo.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saconverse.BeltDemo.models.IceCream;

@Repository
public interface IceCreamRepo extends CrudRepository<IceCream, Long>{
	List<IceCream> findAll();
}
