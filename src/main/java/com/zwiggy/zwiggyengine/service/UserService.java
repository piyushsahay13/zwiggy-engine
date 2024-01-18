/**
 * 
 */
package com.zwiggy.zwiggyengine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.zwiggy.zwiggyengine.model.Customer;

/**
 * @author piyush
 * User service class 
 */

public class UserService {

	@Autowired
	private UserRepoServiceImpl userRepoService;
	
	
	public Customer getCustomerDetailfromId(Optional<String> userid) {
		Customer cust = null;
		
		
		return cust;
	}
}
