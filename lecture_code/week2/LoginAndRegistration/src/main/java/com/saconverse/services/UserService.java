package com.saconverse.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.saconverse.models.LoginUser;
import com.saconverse.models.User;
import com.saconverse.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public User register(User newUser, BindingResult result) {
		if (repo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
		
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match the Password!");
		}
		
		if (result.hasErrors()) {
			return null;
		} else {
			String hash_browns = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hash_browns);
			
			return repo.save(newUser);
		}
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		
		Optional<User> potentialUser = repo.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Invalid Credentials!");
			return null;
		}
		
		User user = potentialUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Credentials!");
		}
		
		if (result.hasErrors()) {
			return null;
		} else {
			return user;
		}
	}
	
	
	public User getOne(Long id) {
		Optional<User> user = repo.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
}
