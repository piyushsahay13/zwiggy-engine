package com.zwiggy.zwiggyengine.service;

import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;

/**
 * Interface for CRUD operations on repositories using the Strategy pattern.
 * Implementations of this interface provide methods for adding, fetching,
 * deleting, and modifying data in a repository.
 *
 * @author piyush
 * @since 1.0
 */
public interface CrudRepoService {

	/**
	 * Adds a new entry to the repository.
	 *
	 * @param obj The object to be added.
	 * @return A message indicating the success or failure of the operation.
	 * @throws RepositoryOperationException If an error occurs during the repository operation.
	 */
	public String addNewEntry(Object obj) throws RepositoryOperationException;

	/**
	 * Fetches existing data from the repository based on the provided ID.
	 *
	 * @param id The ID of the data to be fetched.
	 * @return The fetched object.
	 * @throws RepositoryOperationException If an error occurs during the repository operation.
	 */
	public Object fetchExistingData(String id) throws RepositoryOperationException;

	/**
	 * Deletes data from the repository.
	 *
	 * @return {@code true} if deletion is successful, {@code false} otherwise.
	 */
	public boolean deleteData();

	/**
	 * Modifies existing data in the repository.
	 *
	 * @return {@code true} if modification is successful, {@code false} otherwise.
	 */
	public boolean modifyExistingData();
}

