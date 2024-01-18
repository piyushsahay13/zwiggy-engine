package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends Account {
    @JsonProperty(value = "customerFeedback")
    private List<Feedback> cstmrFeedback;
    @JsonProperty(value = "orderHistory")
    private List<Order> orderHistory;
    @JsonProperty(value = "customerCart")
    private List<Cart> cart;
}
