/**
 * 
 */
package com.zwiggy.zwiggyengine.entity;

import java.sql.Date;

/**
 * @author piyush
 */

public class UserAccount {
	private String fname;
	private String sname;
	private String email;
	private String contactNumber;
	private String address;
	private char usertype;
	private Date userCreationDate;
	
	public String getFname() {
		return fname;
	}
	public String getSname() {
		return sname;
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
