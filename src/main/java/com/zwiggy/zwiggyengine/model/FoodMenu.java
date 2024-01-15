/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author piyush
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodMenu {
	private String cusine;
	private Map<String,String> fooditems;
}
