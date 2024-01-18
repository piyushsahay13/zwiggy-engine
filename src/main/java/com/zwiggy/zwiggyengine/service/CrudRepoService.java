package com.zwiggy.zwiggyengine.service;

import java.util.Optional;

import com.zwiggy.zwiggyengine.entity.UserAccount;

/**
 * @author piyush
 * Strategy to implement CRUD operation
 */
public interface CrudRepoService {
	public boolean addNewEntry(Object obj);
	public Optional<Object> fetchExistingData(String id);
	public boolean deleteData();
	public boolean modifyExistingData();
}
