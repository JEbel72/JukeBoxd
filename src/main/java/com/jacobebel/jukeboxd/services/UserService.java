package com.jacobebel.jukeboxd.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jacobebel.jukeboxd.models.LoginUser;
import com.jacobebel.jukeboxd.models.User;
import com.jacobebel.jukeboxd.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> possibleUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if(possibleUser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		
		if(result.hasErrors()) {
		    return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
	
    public User login(LoginUser newLoginUser, BindingResult result) {
        Optional<User> possibleUser = userRepo.findByEmail(newLoginUser.getEmail());
        
        if (possibleUser.isEmpty()) {
        	result.rejectValue("email", "Matches", "User not found!");
        	return null;
        }
        
        User user = possibleUser.get();
            
        if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
        	result.rejectValue("password", "Matches", "Invalid Password!");
        }
        	
        if(result.hasErrors()) {
            return null;
        } else {
        	return user;
        }
    }
    
    public User getUserById(Long id) {
    	Optional<User> possibleUser = userRepo.findById(id);
    	return possibleUser.isPresent() ? possibleUser.get() : null;
    }
    
}
