package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantResponse {
    @JsonProperty(value = "RestaurantName")
    private String restName;
    @JsonProperty(value = "RestaurantId")
    private String restid;
    @JsonProperty(value = "RestaurantCount")
    private int count;
    @JsonProperty(value = "RestaurantDetails")
    private List<Address> restaurantsList;
}
