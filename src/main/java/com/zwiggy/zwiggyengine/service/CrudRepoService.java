package com.zwiggy.zwiggyengine.service;

import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;

/**
 * @author piyush
 * Strategy to implement CRUD operation
 */
public interface CrudRepoService {
	public String addNewEntry(Object obj) throws RepositoryOperationException;
	public Object fetchExistingData(String id) throws RepositoryOperationException;
	public boolean deleteData();
	public boolean modifyExistingData();
}
