package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
        @JsonProperty(value = "doorNumber")
        private String doorno;
        private String street;
        private String pincode;
        private String city;
        private String googleMapLoc;
}
