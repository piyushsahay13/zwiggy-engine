/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * @author piyush
 *
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodMenu {
	@JsonProperty(value = "Cusine")
	private String cusine;
	@JsonProperty(value = "FoodItems")
	private List<FoodItems> fooditems;
}
