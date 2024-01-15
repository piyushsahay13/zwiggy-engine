/**
 * 
 */
package com.zwiggy.zwiggyengine.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zwiggy.zwiggyengine.entity.UserAccount;

/**
 * @author Piyush
 * 
 * CRUD Repository for UserAccount
 *
 */
public interface UserAccountRepository extends CrudRepository<UserAccount, String> {

}
