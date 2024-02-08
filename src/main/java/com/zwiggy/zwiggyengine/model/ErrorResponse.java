/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author piyush
 * Custom Error Response for Zwiggy Engine
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	
	@JsonProperty(value = "ErrorCode")
	private String errCd;
	@JsonProperty(value = "ErrorMessage")
	private String errMsg;
	@JsonProperty(value = "Support")
	private String support;
	@JsonProperty(value = "Cause")
	private String excCause;
	@JsonProperty(value = "StackTrace")
	private StackTraceElement[] stkTrace;


	public ErrorResponse() {
		this.setSupport("support_engine@zwiggy.com");
	}
}
