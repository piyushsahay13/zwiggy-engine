package com.zwiggy.zwiggyengine.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

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
@SequenceGenerator(name = "IDSEQUENCE", sequenceName = "IDSEQUENCE", allocationSize = 1)
public class UserAccount {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDSEQUENCE")
	private Integer uid;
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
}
