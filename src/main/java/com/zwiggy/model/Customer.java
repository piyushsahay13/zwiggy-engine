package com.zwiggy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Customer {
    @JsonProperty(value = "customerAccountDetails")
    private Account cstmrAccDetails;
    @JsonProperty(value = "customerFeedback")
    private List<Feedback> cstmrFeedback;
    @JsonProperty(value = "orderHistory")
    private List<Order> orderHistory;
}
