package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Food Item pojo to store list of food item name and price
 * @Aauthor piyush sahay
 */

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodItems {
    private String itemName;
    private Double price;
}
