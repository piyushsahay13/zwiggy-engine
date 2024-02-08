package com.zwiggy.zwiggyengine.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Account {
    protected Account(String fName, String sName, String email, String contactNo, List<Address> address, UserType userType, String longitudeLatitude) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
        this.userType = userType;
        this.longitudeLatitude = longitudeLatitude;
    }
	@NotBlank(message = "First name is mandatory")
	@NotNull(message = "First name is mandatory")
	@JsonProperty(value = "FirstName")
	private String fName;
	@NotNull(message = "Last name is mandatory")
	@NotBlank(message = "Last name is mandatory")
	@JsonProperty(value = "LastName")
	private String sName;
	@NotNull(message = "Email Id is mandatory")
	@JsonProperty(value = "EmailId")
	private String email;
	@NotNull(message = "Contact number is mandatory")
	@JsonProperty(value = "ContactNumber")
	private String contactNo;
	@JsonProperty(value = "Address")
	private List<Address> address;
	@NotNull(message = "User Type is mandatory")
	@JsonProperty(value = "UserType")
	private UserType userType;
	@JsonProperty(value = "locationCordinates")
	private String longitudeLatitude;
}
