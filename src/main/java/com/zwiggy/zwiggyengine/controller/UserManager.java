/**
 * 
 */
package com.zwiggy.zwiggyengine.controller;

import java.util.Optional;

import com.zwiggy.zwiggyengine.model.Customer;
import com.zwiggy.zwiggyengine.model.Response;
import com.zwiggy.zwiggyengine.model.UserType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;
import com.zwiggy.zwiggyengine.exception.UserValidationException;
import com.zwiggy.zwiggyengine.model.Account;
import com.zwiggy.zwiggyengine.service.UserService;
import com.zwiggy.zwiggyengine.util.RequestValidator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author piyush
 * User Manager REST end points
 */

@RestController
@Api("User manager apis")
@RequestMapping(value = "/user")
@Slf4j
@Validated
public class UserManager {
	
	@Autowired
	private UserService userService;


	@ApiOperation(value = "Get user account detail", notes = "This endpoint returns user information based on usertype.")
	@GetMapping(value = "/fetchAccount", produces = "application/json")
	public ResponseEntity<Object> getUserDetails(@RequestParam Optional<String> userid) throws UserValidationException, InvalidUserException, RepositoryOperationException {
		RequestValidator.validateUserId(userid);
		return new ResponseEntity<>(userService.getCustomerDetailfromId(userid),HttpStatus.OK);
	}

	@ApiOperation(value = "Create new customer account", notes = "This endpoint create a new customer.")
	@PostMapping(value = "/createCustomer/v1", produces = "application/json")
	public ResponseEntity<Response> createNewUser(@Valid @RequestBody Customer user) throws UserValidationException, InvalidUserException, RepositoryOperationException {
		log.info(user.toString() + " requested to create new account.");
		RequestValidator.validateUser(user, UserType.getCodefrmUsrType(UserType.USER));
		return new ResponseEntity<>(userService.addNewCustomer(user),HttpStatus.OK);
	}
}
