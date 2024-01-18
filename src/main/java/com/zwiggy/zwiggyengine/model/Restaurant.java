/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author piyush
 * POJO for Restaurant
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant extends Account{
	private List<FoodMenu> restaurantMenu;
	private List<Feedback> restFeedback;
	private float avgRating;
}
