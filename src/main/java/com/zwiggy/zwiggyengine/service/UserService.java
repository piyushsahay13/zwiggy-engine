package com.zwiggy.zwiggyengine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwiggy.zwiggyengine.constant.AppConstant;
import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;

/**
 * @author piyush
 * User service class 
 */

@Service
public class UserService {

	@Autowired
	private UserRepoServiceImpl userRepoService;
	
	public Response addNewCustomer(Customer userDetails) throws InvalidUserException, RepositoryOperationException {
		UserAccount user = new UserAccount();
		user.setEmail(userDetails.getEmail());
		user.setAddress(userDetails.getAddress().get(0).toString());
		user.setFname(userDetails.getFName());
		user.setLname(userDetails.getSName());
		user.setContactNumber(userDetails.getContactNo());
		user.setUsertype(UserType.getCodefrmUsrType(userDetails.getUserType()));
		user.setUserCreationDate(getTodaysDate());
		return Response.builder()
				.responseMsg(userRepoService.addNewEntry(user) + AppConstant.USERADDED)
				.respType(AppConstant.SUCCESS)
				.build();
	}
	
	public Customer getCustomerDetailfromId(Optional<String> userid) throws InvalidUserException, RepositoryOperationException {
		String userIdToString = userid.orElseThrow(() -> new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERIDERROR)));
		UserAccount response = (UserAccount) userRepoService.fetchExistingData(userIdToString);
		List<Address> address = new ArrayList<>();
		return Customer.customerBuilder()
				.fName(response.getFname())
				.sName(response.getLname())
				.email(response.getEmail())
				.contactNo(response.getContactNumber())
				.address(address)
				.userType(UserType.getCodeUsrType(response.getUsertype()))
				.longitudeLatitude(null)
				.cstmrFeedback(null)
				.orderHistory(null)
				.cart(null)
				.build();
	}

	public List<Address> addressDeserializerService() {
		return null;
	}
	
	public Date getTodaysDate() {
		return new java.util.Date();
	}
}
