/**
 * 
 */
package com.zwiggy.zwiggyengine.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;
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
	
	@Override
	public String addNewEntry(Object newuser) throws RepositoryOperationException {
		try {
			return repo.save((UserAccount) newuser).getEmail();
		}
		catch(IllegalArgumentException exp ) {
			log.info("Exception occured while saving to repository : " + exp.getCause() + " ::: " + exp.getStackTrace());
			throw new RepositoryOperationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.HIBERNATERROR),exp);
		}
		catch(OptimisticLockingFailureException exp) {
			throw exp;
		}
	}

	@Override
	public Object fetchExistingData(String id) throws RepositoryOperationException {
		try {
			log.info("Fetching Account details for : " + id);
			Optional<UserAccount> user = repo.findById(id);
			log.info("User Details : " + user.toString());
			return user.get();
		}
		catch (NoSuchElementException exp) {
			log.info("Exception occured while fetching from repository : " + exp.getMessage() + " ::: " + exp.getStackTrace());
			throw new RepositoryOperationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERNOTEXIST),exp);
		}
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
