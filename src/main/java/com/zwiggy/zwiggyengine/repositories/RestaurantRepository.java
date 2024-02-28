package com.zwiggy.zwiggyengine.repositories;

import com.zwiggy.zwiggyengine.entity.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing restaurant entities using Spring Data JPA.
 * Provides CRUD operations and additional queries for the Restaurants entity.
 *
 * @author piyush
 * @since 1.0
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {

    // No additional methods are declared in this interface.
    // Spring Data JPA will provide CRUD operations and queries based on the entity.
}
