package com.zwiggy.zwiggyengine.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * FoodItemsEntity is an entity class representing a food item with details such as item name, price, and availability.
 *
 * @author piyush
 */
@Data
public class FoodItemsEntity {

    /**
     * The name of the food item.
     *
     * @Field("ItemName")
     */
    private String itemName;

    /**
     * The price of the food item.
     *
     * @Field("Price")
     */
    private Double price;

    /**
     * Indicates whether the food item is available or not.
     *
     * @Field("IsAvailaible")
     */
    private boolean isAvailaible;
}
