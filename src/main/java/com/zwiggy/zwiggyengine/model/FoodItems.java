package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 * Food Item pojo to store list of food item name and price
 * @Aauthor piyush sahay
 */

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodItems {
    @NotBlank(message = "ItemName name is mandatory")
    @NotNull(message = "ItemName name is mandatory")
    @JsonProperty(value = "ItemName")
    private String itemName;
    @NotBlank(message = "Price name is mandatory")
    @NotNull(message = "Price name is mandatory")
    @JsonProperty(value = "Price")
    private Double price;
    @NotBlank(message = "IsAvailaible flag is mandatory")
    @NotNull(message = "IsAvailaible flag is mandatory")
    @JsonProperty(value = "IsAvailaible")
    private boolean isAvailaible;
}
