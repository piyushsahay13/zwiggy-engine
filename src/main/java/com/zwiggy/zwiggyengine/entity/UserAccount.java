package com.zwiggy.zwiggyengine.entity;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author piyush
 * Entity class for USERACCOUNT table
 */

@Entity
@Table(name = "USERACCOUNT")
@Data
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
	@Temporal(TemporalType.DATE)
	private Date userCreationDate;
}
