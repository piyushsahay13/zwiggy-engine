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
import com.zwiggy.zwiggyengine.entity.UserAccountEntity;
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

	/**
	 * Adds a new entry to the repository.
	 *
	 * @param newuser The object to be added.
	 * @return A message indicating the success or failure of the operation.
	 * @throws RepositoryOperationException If an error occurs during the repository operation.
	 */
	@Override
	public String addNewEntry(Object newuser) throws RepositoryOperationException {
		try {
			return repo.save((UserAccountEntity) newuser).getEmail();
		}
		catch(IllegalArgumentException exp ) {
			log.info("Exception occured while saving to repository : " + exp.getCause() + " ::: " + exp.getStackTrace());
			throw new RepositoryOperationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.HIBERNATERROR),exp);
		}
		catch(OptimisticLockingFailureException exp) {
			throw exp;
		}
	}

	/**
	 * Fetches existing data from the repository based on the provided ID.
	 *
	 * @param id The ID of the data to be fetched.
	 * @return The fetched object.
	 * @throws RepositoryOperationException If an error occurs during the repository operation.
	 */
	@Override
	public Object fetchExistingData(String id) throws RepositoryOperationException {
		try {
			log.info("Fetching Account details for : " + id);
			Optional<UserAccountEntity> user = repo.findById(id);
			log.info("User Details : " + user.toString());
			return user.get();
		}
		catch (NoSuchElementException exp) {
			log.info("Exception occured while fetching from repository : " + exp.getMessage() + " ::: " + exp.getStackTrace());
			throw new RepositoryOperationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERNOTEXIST),exp);
		}
	}

	/**
	 * Deletes data from the repository.
	 *
	 * @return {@code true} if deletion is successful, {@code false} otherwise.
	 */
	@Override
	public boolean deleteData() {
		return false;
	}

	/**
	 * Modifies existing data in the repository.
	 *
	 * @return {@code true} if modification is successful, {@code false} otherwise.
	 */
	@Override
	public boolean modifyExistingData() {
		return false;
	}

	/**
	 * @param userid
	 *
	 * @return The fetched object using primary key
	 */
	public boolean userExist(String userid) {
        return repo.existsById(userid);
    }

}
