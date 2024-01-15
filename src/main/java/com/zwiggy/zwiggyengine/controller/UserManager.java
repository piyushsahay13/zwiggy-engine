/**
 * 
 */
package com.zwiggy.zwiggyengine.controller;

import java.util.Optional;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwiggy.zwiggyengine.model.Customer;

/**
 * @author piyush
 * User Manager
 */

@RestController
@RequestMapping(value = "/user")
public class UserManager {
	
	@GetMapping(value = "/fetchUserAccount", produces = "application/json")
	public ResponseEntity<Customer> getUserDetails(@RequestParam Optional<String> userid) {
		
		return new ResponseEntity<>(new Customer(),HttpStatus.OK);
	}
}
