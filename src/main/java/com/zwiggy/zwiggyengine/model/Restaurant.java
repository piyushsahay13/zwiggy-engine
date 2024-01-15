/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author piyush
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant {
	private List<FoodMenu> restaurantMenu;
	private List<Address> restAdress;
	private List<Feedback> restFeedback;
	private float avgRating;
}
