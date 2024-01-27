package com.zwiggy.zwiggyengine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.model.Address;
import com.zwiggy.zwiggyengine.model.Customer;
import com.zwiggy.zwiggyengine.model.UserType;

/**
 * @author piyush
 * User service class 
 */

@Service
public class UserService {

	@Autowired
	private UserRepoServiceImpl userRepoService;
	
	
	public Customer getCustomerDetailfromId(Optional<String> userid) throws InvalidUserException {
		String userIdToString  = userid.get().toString();
		UserAccount userresponse = (UserAccount) userRepoService.fetchExistingData(userIdToString);
		List<Address> address = new ArrayList<>();
		Customer customer = Customer.customerBuilder()
				.fName(userresponse.getFname())
				.sName(userresponse.getLname())
				.email(userresponse.getEmail())
				.contactNo(userresponse.getContactNumber())
				.address(address)
				.userType(UserType.getCodeUsrType(userresponse.getUsertype()))
				.cstmrFeedback(null)
				.orderHistory(null)
				.cart(null)
				.build();
		return customer;
	}
//	java.lang.String,
//	java.lang.String,
//	java.lang.String,
//	java.lang.String,
//	java.util.List<com.zwiggy.zwiggyengine.model.Address>,
//	com.zwiggy.zwiggyengine.model.UserType,
//	java.util.List<com.zwiggy.zwiggyengine.model.Feedback>,
//	java.util.List<com.zwiggy.zwiggyengine.model.Order>,
//	java.util.List<com.zwiggy.zwiggyengine.model.Cart>
	//found:    java.util.List<com.zwiggy.zwiggyengine.model.Feedback>,java.util.List<com.zwiggy.zwiggyengine.model.Order>,java.util.List<com.zwiggy.zwiggyengine.model.Cart>
	public List<Address> AddressDeserializerService() {
		return null;
	}
	
	public Date getTodaysDate() {
		return new java.util.Date();
	}
}
