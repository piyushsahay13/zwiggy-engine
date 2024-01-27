package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Account {
    protected Account(String fName, String sName, String email, String contactNo, List<Address> address, UserType userType) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
        this.userType = userType;
    }
	@JsonProperty(value = "FirstName")
	private String fName;
	@JsonProperty(value = "LastName")
	private String sName;
	@JsonProperty(value = "EmailId")
	private String email;
	@JsonProperty(value = "ContactNumber")
	private String contactNo;
	@JsonProperty(value = "Address")
	private List<Address> address;
	@JsonProperty(value = "UserType")
	private UserType userType;
}
