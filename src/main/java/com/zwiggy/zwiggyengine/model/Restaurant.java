/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author piyush POJO for Restaurant
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant extends Account {
	
	public Restaurant(String fName, String sName, String email, String contactNo, List<Address> address,
			UserType userType, List<Feedback> restFeedback, List<FoodMenu> restaurantMenu, float avgRating) {
		super(fName, sName, email, contactNo, address, userType);
		this.restFeedback = restFeedback;
		this.avgRating = avgRating;
		this.restaurantMenu = restaurantMenu;

	}

	private List<FoodMenu> restaurantMenu;
	private List<Feedback> restFeedback;
	private float avgRating;
}
