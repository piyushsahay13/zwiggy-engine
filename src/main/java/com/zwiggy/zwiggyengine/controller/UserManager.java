/**
 * 
 */
package com.zwiggy.zwiggyengine.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwiggy.zwiggyengine.model.Account;
import com.zwiggy.zwiggyengine.model.Customer;

/**
 * @author piyush
 * User Manager REST endpoints
 */

@RestController
@RequestMapping(value = "/user")
public class UserManager {
	
	@GetMapping(value = "/FetchAccount", produces = "application/json")
	public ResponseEntity<Customer> getUserDetails(@RequestParam Optional<String> userid) {
		return new ResponseEntity<>(new Customer(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/CreateNewAccount", produces = "application/json")
	public ResponseEntity<String> getUserDetails(@RequestBody Account user) {
		String response = null;
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
