/**
 * 
 */
package com.zwiggy.zwiggyengine.service;

import java.util.Optional;

import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.model.Account;

/**
 * @author piyush
 *
 */
public interface UserRepoService {

	public boolean adduser(Account user);
	public Optional<UserAccount> getUser(String userId);
	public boolean deletUser();
	public boolean modifyUser();
}
