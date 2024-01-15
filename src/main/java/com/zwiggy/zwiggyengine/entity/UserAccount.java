package com.zwiggy.zwiggyengine.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author piyush
 */

@Entity
@Table(name = "USERACCOUNT")
public class UserAccount {
	@Id
	@Column(name = "EMAIL")
	private String email;
	@Column(name ="FIRSTNAME")
	private String fname;
	@Column(name = "LASTNAME")
	private String lname;
	@Column(name = "CONTACTNUMBER")
	private String contactNumber;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "USERTYPE")
	private char usertype;
	@Column(name = "ACCOUNTCREATIONDATE")
	private Date userCreationDate;
	
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getEmail() {
		return email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public char getUsertype() {
		return usertype;
	}
	public Date getUserCreationDate() {
		return userCreationDate;
	}

	
}
