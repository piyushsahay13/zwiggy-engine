package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author piyush
 * Response entity to return response for api
 */
@Data
@Builder
public class Response {

    @JsonProperty(value = "ResponseMessage")
    private String responseMsg;
    @JsonProperty(value = "ResponseType")
    private String respType;

}
