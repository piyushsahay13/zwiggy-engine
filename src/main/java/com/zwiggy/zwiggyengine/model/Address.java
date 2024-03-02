package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
        @NotBlank(message = "DoorNumber is mandatory")
        @NotNull(message = "DoorNumber is mandatory")
        @JsonProperty(value = "DoorNumber")
        private String doorno;
        @NotBlank(message = "Street detail is mandatory")
        @NotNull(message = "Street detail name is mandatory")
        @JsonProperty(value = "Street")
        private String street;
        @NotBlank(message = "City is mandatory")
        @NotNull(message = "City name is mandatory")
        @JsonProperty(value = "City")
        private String city;
        @NotBlank(message = "State is mandatory")
        @NotNull(message = "State name is mandatory")
        @JsonProperty(value = "State")
        private String state;
        @NotBlank(message = "Pincode name is mandatory")
        @NotNull(message = "Pincode name is mandatory")
        @JsonProperty(value = "Pincode")
        private String pincode;
        @JsonProperty(value = "LocationCoordinates")
        private String googleMapLoc;
//        @JsonProperty(value = "RestaurantMenu")
//        private List<FoodMenu> restaurantMenu;
}
