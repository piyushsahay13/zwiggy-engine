/**
 * 
 */
package com.zwiggy.zwiggyengine.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zwiggy.zwiggyengine.entity.UserAccount;

/**
 * @author Piyush
 * 
 * CRUD Repository for UserAccount
 *
 */
@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, String> {

}
