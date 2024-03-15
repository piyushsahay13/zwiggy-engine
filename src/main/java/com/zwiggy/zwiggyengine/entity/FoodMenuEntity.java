package com.zwiggy.zwiggyengine.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * FoodMenuEntity is an entity class representing a food menu with details such as cuisine and a list of food items.
 *
 * @author piyush
 */
@Data
public class FoodMenuEntity {

    /**
     * The cuisine associated with the food menu.
     *
     * @Field("Cusine")
     */
    private String cusine;

    /**
     * The list of food items included in the food menu.
     *
     * @Field("FoodItems")
     */
    private List<FoodItemsEntity> foodItems;
}
