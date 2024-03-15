package com.zwiggy.zwiggyengine.repositories;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.entity.BranchEntity;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class MenuRepoServiceImpl implements CrudRepoService {

    @Autowired
    private MenuRepository repository;

    /**
     * Adds a new entry to the repository.
     *
     * @param menu The object to be added.
     * @return A message indicating the success or failure of the operation.
     * @throws RepositoryOperationException If an error occurs during the repository operation.
     */
    @Override
    public String addNewEntry(Object menu) throws RepositoryOperationException {
        try {
            return repository.insert((BranchEntity) menu).getRestaurantId();
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
     * @param restid The ID of the data to be fetched.
     * @return The fetched object.
     * @throws RepositoryOperationException If an error occurs during the repository operation.
     */
    @Override
    public Object fetchExistingData(String restid) throws RepositoryOperationException {
        try {
            log.info("Fetching Account details for : " + restid);
            Optional<BranchEntity> menu = repository.findById(restid);
            log.info("Menu Details : " + menu.toString());
            return menu;
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

    public BranchEntity fetchByemail(String email){
        try {
            log.info("Fetching Account details for : " + email);
            BranchEntity branchEntity = repository.findByEmailId(email);
            log.info("Menu Details : " + branchEntity.toString());
            return branchEntity;
        }
        catch (NoSuchElementException exp) {
            log.info("Exception occured while fetching from repository : " + exp.getMessage() + " ::: " + exp.getStackTrace());
            throw new RepositoryOperationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERNOTEXIST),exp);
        }
    }
}
