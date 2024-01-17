package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
	private String fName;
	private String sName;
	private String email;
	private String contactNo;
	private List<Address> custAddress;
	private UserType userType;
}
