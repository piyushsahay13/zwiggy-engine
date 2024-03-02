/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 *  FoodMenu is a data class representing a food menu with cuisine and a list of food items.
 *  It includes validation annotations to ensure the mandatory nature of the cuisine and food items.
 *
 * @author piyush
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodMenu {
	@NotBlank(message = "Cusine detail is mandatory")
	@NotNull(message = "Cusine detail is mandatory")
	@JsonProperty(value = "Cusine")
	private String cusine;
	@NotBlank(message = "FoodItems is mandatory")
	@NotNull(message = "FoodItems name is mandatory")
	@JsonProperty(value = "FoodItems")
	private List<FoodItems> fooditems;

}
