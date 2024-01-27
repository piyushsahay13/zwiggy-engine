/**
 * 
 */
package com.zwiggy.zwiggyengine.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.exception.UserValidationException;
import com.zwiggy.zwiggyengine.model.Account;
import com.zwiggy.zwiggyengine.model.Customer;
import com.zwiggy.zwiggyengine.service.UserService;
import com.zwiggy.zwiggyengine.util.RequestValidator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author piyush
 * User Manager REST end points
 */

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserManager {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/FetchAccount", produces = "application/json")
	public ResponseEntity<Object> getUserDetails(@RequestParam Optional<String> userid) throws UserValidationException, InvalidUserException {
		log.info("Get details for user id {} : "+ userid.get());
		RequestValidator.validateUserId(userid);
		return new ResponseEntity<>(userService.getCustomerDetailfromId(userid),HttpStatus.OK);
	}
	
	@PostMapping(value = "/CreateNewAccount", produces = "application/json")
	public ResponseEntity<String> createNewUser(@RequestBody Account user) {
		String response = null;
		log.info(user.toString() + " requested to create new account.");
		
//		if(userRepoService.addNewEntry(user))
//			response = user.getEmail() + "Added Successfully!";
//		else
//			response = "Failed adding new user.";
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
