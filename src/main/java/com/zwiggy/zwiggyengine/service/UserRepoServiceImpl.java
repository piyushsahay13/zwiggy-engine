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
public class UserRepoServiceImpl implements UserRepoService {
	
	@Autowired
	private UserAccountRepository repo;
	
	@Override
	public boolean adduser(Account newuser) {
		UserAccount user = new UserAccount();
		user.setEmail(newuser.getEmail());
		user.setAddress(newuser.getCustAddress().get(0).toString());
		user.setFname(newuser.getFName());
		user.setLname(newuser.getSName());
		user.setContactNumber(newuser.getContactNo());
		user.setUsertype('U');
//		user.setUserCreationDate(java.time.LocalDate.now());
		if(repo.save(user)!=null)
			return true;
		return false;
	}

	@Override
	public Optional<UserAccount> getUser(String userid) {
		log.info(userid);
		Optional<UserAccount> user = repo.findById(userid);
		log.info(user.toString());
		return user;
	}

	@Override
	public boolean deletUser() {
		return false;
	}
	
	@Override
	public boolean modifyUser() {
		return false;
	}

}
