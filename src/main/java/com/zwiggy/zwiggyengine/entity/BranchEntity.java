package com.zwiggy.zwiggyengine.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * BranchEntity is an entity class representing a branch of a restaurant, including details such as the restaurant ID,
 * restaurant name, email ID, branch details, and the last updated timestamp.
 *
 * @author piyush
 */
@Data
@Document(collection = "Branch")
public class BranchEntity {

    /**
     * The unique identifier for the restaurant.
     *
     * @Id
     * @Field("RestaurantId")
     */
    private String restaurantId;

    /**
     * The name of the restaurant.
     *
     * @Field("RestaurantName")
     */
    private String restName;

    /**
     * The email ID associated with the restaurant.
     *
     * @Field("EmailId")
     */
    private String emailId;

    /**
     * The list of branch details associated with the restaurant.
     *
     * @Field("BranchDetails")
     */
    private List<BranchDetailsEntity> restaurants;

    /**
     * The timestamp representing the last update of the branch details.
     *
     * @Field("LastUpdated")
     */
    private Date timeStamp;

}
