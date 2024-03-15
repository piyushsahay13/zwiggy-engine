package com.zwiggy.zwiggyengine.repositories;

import com.zwiggy.zwiggyengine.entity.RestaurantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing restaurant entities using Spring Data JPA.
 * Provides CRUD operations and additional queries for the Restaurants entity.
 *
 * @author piyush
 * @since 1.0
 */
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantsEntity, Long> {

    Optional<RestaurantsEntity> findByRestaurantId(String restaurantId);

    @Query("select restaurantId from RestaurantsEntity where emailId=:email")
    String findRestIdByEmail(@Param("email") String email);

}
