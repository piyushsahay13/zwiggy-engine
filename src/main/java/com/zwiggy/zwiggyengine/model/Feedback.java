package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feedback {
	private String restId;
	private String custId;
	private List<String> comments;
	private List<String> rating;
}
