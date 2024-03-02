package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author piyush
 * Response entity to return response for api
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    @JsonProperty(value = "RestaurantId")
    private String restId;
    @JsonProperty(value = "ResponseMessage")
    private String responseMsg;
    @JsonProperty(value = "ResponseType")
    private String respType;
    @JsonProperty(value = "UserLoginEmail")
    private String emailId;
}
