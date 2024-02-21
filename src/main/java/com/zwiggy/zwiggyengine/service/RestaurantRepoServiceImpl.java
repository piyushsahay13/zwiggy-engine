package com.zwiggy.zwiggyengine.service;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.entity.Restaurants;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;
import com.zwiggy.zwiggyengine.repositories.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestaurantRepoServiceImpl implements CrudRepoService {

    @Autowired
    private RestaurantRepository repo;

    /**
     * Adds a new entry to the repository.
     *
     * @param restDetails The object to be added.
     * @return A message indicating the success or failure of the operation.
     * @throws RepositoryOperationException If an error occurs during the repository operation.
     */
    @Override
    public String addNewEntry(Object restDetails) throws RepositoryOperationException {
        try {
            return repo.save((Restaurants) restDetails).getRestaurantId();
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
        return null;
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
}
