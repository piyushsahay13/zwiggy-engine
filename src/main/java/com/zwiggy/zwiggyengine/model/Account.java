package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
	public String fName;
	public String sName;
	public String email;
	public String contactNo;
	public List<Address> custAddress;
	public UserType userType;
}
