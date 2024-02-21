package com.zwiggy.zwiggyengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zwiggy.zwiggyengine.entity.UserAccount;

/**
 * Repository interface for managing userAccount entities using Spring Data JPA.
 * Provides CRUD operations and additional queries for the userAccount entity.
 *
 * @author piyush
 * @since 1.0
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

}
