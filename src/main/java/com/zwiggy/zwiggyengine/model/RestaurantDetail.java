package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantDetail extends Address{
    @NotBlank(message = "Supervisor name is mandatory")
    @NotNull(message = "Supervisor name is mandatory")
    @JsonProperty(value = "SupervisorName")
    private String supName;
    @NotBlank(message = "Supervisor Contact is mandatory")
    @NotNull(message = "Supervisor Contact is mandatory")
    @JsonProperty(value = "SupervisorContact")
    private String supContact;
    @NotBlank(message = "FSSAILicenceNo is mandatory")
    @NotNull(message = "FSSAILicenceNo is mandatory")
    @JsonProperty(value = "FSSAILicenceNo")
    private String licNo;
    @JsonProperty(value = "RestaurantMenu")
    private List<FoodMenu> restaurantMenu;
}
