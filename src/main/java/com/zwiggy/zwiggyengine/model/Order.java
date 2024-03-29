package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
	@JsonProperty(value ="Status")
	private OrderStatus status;
	
}
