package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feedback {
	@JsonProperty(value = "RestaurantId")
	private String restId;
	@JsonProperty(value = "CustomerId")
	private String custId;
	@JsonProperty(value = "Comments")
	private List<String> comments;
	@JsonProperty(value = "Rating")
	private List<String> rating;
}
