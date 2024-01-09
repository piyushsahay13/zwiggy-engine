/**
 * 
 */
package com.zwiggy.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwiggy.model.Account;

/**
 * @author piyush
 * User Manager
 */

@RestController
@RequestMapping(value = "/user")
public class UserManager {
	
	@GetMapping(value = "fetchUser", produces = "application/json")
	public ResponseEntity<Account> getUserDetails(@RequestParam Optional<String> userid) {
		return new ResponseEntity<>(new Account(),HttpStatus.OK);
	}
}
