/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author piyush POJO for Restaurant
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant extends Account {
	
	public Restaurant(String fName, String sName, String email, String contactNo, List<Address> address,
			UserType userType, String longitudeLatitude, List<Feedback> restFeedback, float avgRating, String restaurantName, boolean isOnlyVeg) {
		super(fName, sName, email, contactNo, address, userType, longitudeLatitude);
		this.restFeedback = restFeedback;
		this.avgRating = avgRating;
		this.restaurantName = restaurantName;
		this.isOnlyVeg = isOnlyVeg;
	}
	@JsonProperty(value = "RestaurantName")
	@NotNull
	private String restaurantName;
	@JsonProperty(value = "IsPureVeg")
	private boolean isOnlyVeg;
	@JsonProperty(value = "RestaurantFeedback")
	private List<Feedback> restFeedback;
	@JsonProperty(value = "AverageRating")
	private float avgRating;
}
