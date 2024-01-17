/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author piyush
 * Custom Error Response for Zwiggy Engine
 */
@Data
public class ErrorResponse {
	
	@JsonProperty(value = "ErrorCode")
	private String errCd;
	@JsonProperty(value = "ErrorMessage")
	private String errMsg;
	@JsonProperty(value = "Support")
	private String support;
	@JsonProperty(value = "StackTrace")
	private String stkTrace;

	public ErrorResponse() {
		this.setSupport("Please reach out to support_engine@zwiggy.com for more help!");
	}
}
