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

import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.model.Account;
import com.zwiggy.zwiggyengine.model.Customer;
import com.zwiggy.zwiggyengine.service.UserRepoServiceImpl;
import com.zwiggy.zwiggyengine.util.ValidatorUtility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author piyush
 * User Manager REST endpoints
 */

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserManager {
	
	@Autowired
	UserRepoServiceImpl userRepoService;
	
	@GetMapping(value = "/FetchAccount", produces = "application/json")
	public ResponseEntity<Customer> getUserDetails(@RequestParam Optional<String> userid) {
		try {
			if(ValidatorUtility.validateUserId(userid)) {
				
			}
			else {
				throw new 
			}
		}

			
//		Customer cust = new Customer();
//		Optional<UserAccount> userresponse = userRepoService.getUser(userid.toString());
//		log.info(userresponse);
//		if(userresponse.isPresent())
//			cust.setCstmrAccDetails(null)
		return new ResponseEntity<>(new Customer(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/CreateNewAccount", produces = "application/json")
	public ResponseEntity<String> createNewUser(@RequestBody Account user) {
		String response = null;
		log.info(user.toString());
		if(userRepoService.adduser(user))
			response = user.getEmail() + "Added Successfully!";
		else
			response = "Failed adding new user.";
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
