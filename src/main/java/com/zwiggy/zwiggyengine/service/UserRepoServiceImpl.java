/**
 * 
 */
package com.zwiggy.zwiggyengine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.model.Account;
import com.zwiggy.zwiggyengine.repositories.UserAccountRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author piyush
 * User Repository Service Implementation to perform CRUD Operation
 */
@Service
@Slf4j
public class UserRepoServiceImpl implements CrudRepoService {
	
	@Autowired
	private UserAccountRepository repo;
	
	@Autowired
	private UserService usrSvc;
	
	@Override
	public boolean addNewEntry(Object newuser) {
		UserAccount user = new UserAccount();
		Account castUser = (Account) newuser;
		user.setEmail(castUser.getEmail());
		user.setAddress(castUser.getAddress().get(0).toString());
		user.setFname(castUser.getFName());
		user.setLname(castUser.getSName());
		user.setContactNumber(castUser.getContactNo());
		user.setUsertype('U');
		user.setUserCreationDate(usrSvc.getTodaysDate());
		if(repo.save(user)!=null)
			return true;
		return false;
	}

	@Override
	public Object fetchExistingData(String id) {
		log.info("Fetching Account details for : " + id);
		Optional<UserAccount> user = repo.findById(id);
		log.info("User Details : " + user.toString());
		return Optional.of(user.get());
	}

	@Override
	public boolean deleteData() {
		return false;
	}
	
	@Override
	public boolean modifyExistingData() {
		return false;
	}

}
