package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
        @JsonProperty(value = "DoorNumber")
        private String doorno;
        @JsonProperty(value = "Street")
        private String street;
        @JsonProperty(value = "City")
        private String city;
        @JsonProperty(value = "State")
        private String state;
        @JsonProperty(value = "Pincode")
        private String pincode;
        private String googleMapLoc;
        @JsonProperty(value = "AddressType")
        private String addType;
        @JsonProperty(value = "RestaurantMenu")
        private List<FoodMenu> restaurantMenu;
}
