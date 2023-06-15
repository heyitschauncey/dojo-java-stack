package com.heidichen.authdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.heidichen.authdemo.models.LoginUser;
import com.heidichen.authdemo.models.User;
import com.heidichen.authdemo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
    public User register(User newUser, BindingResult result) {
        // TO-DO - Reject values: 
        // Reject if email is taken (present in database)
        // 1. Find user in the DB by email    
        // 2. if the email is present , reject
        // Reject if password doesn't match confirmation
        // if result has errors, return 
        // Hash and set password, save user to database  
    }
        
    public User login(LoginUser newLogin, BindingResult result) {
    // TO-DO - Reject values: 
        // Find user in the DB by email
        // 1. Find user in the DB by email    
        // 2. if the email is not present , reject      
        // 3.1 grab the user from potential user    
        // 3.2 if BCrypt password match fails
        // 4 if result has errors,return
        // Otherwise, return the user object
    }
        

}
