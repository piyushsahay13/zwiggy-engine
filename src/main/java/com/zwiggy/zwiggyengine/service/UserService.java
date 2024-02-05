package com.zwiggy.zwiggyengine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwiggy.zwiggyengine.constant.AppConstant;
import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;
import com.zwiggy.zwiggyengine.model.Account;
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
	
	public String addNewCustomer(Account userDetails) throws InvalidUserException, RepositoryOperationException {
		UserAccount user = new UserAccount();
		user.setEmail(userDetails.getEmail());
		user.setAddress(userDetails.getAddress().get(0).toString());
		user.setFname(userDetails.getFName());
		user.setLname(userDetails.getSName());
		user.setContactNumber(userDetails.getContactNo());
		user.setUsertype(UserType.getCodefrmUsrType(userDetails.getUserType()));
		user.setUserCreationDate(getTodaysDate());
		return userRepoService.addNewEntry(user) + AppConstant.USERADDED;
	}
	
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
				.longitudeLatitude(null)
				.cstmrFeedback(null)
				.orderHistory(null)
				.cart(null)
				.build();
		return customer;
	}

	public List<Address> AddressDeserializerService() {
		return null;
	}
	
	public Date getTodaysDate() {
		return new java.util.Date();
	}
}
