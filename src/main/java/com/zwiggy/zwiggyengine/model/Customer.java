package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends Account {
    @Builder(builderMethodName = "customerBuilder")
    public Customer(String fName, String sName, String email, String contactNo, List<Address> address, UserType userType, String longitudeLatitude,
                    List<Feedback> cstmrFeedback, List<Order> orderHistory, List<Cart> cart) {
        super(fName, sName, email, contactNo, address, userType, longitudeLatitude);
        this.cstmrFeedback = cstmrFeedback;
        this.orderHistory = orderHistory;
        this.cart = cart;
    }
    @JsonProperty(value = "customerFeedback")
    private List<Feedback> cstmrFeedback;
    @JsonProperty(value = "orderHistory")
    private List<Order> orderHistory;
    @JsonProperty(value = "customerCart")
    private List<Cart> cart;
}
