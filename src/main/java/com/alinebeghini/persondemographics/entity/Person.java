package com.alinebeghini.persondemographics.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity Person
 * 
 * @author Aline
 *
 */
@Entity
public class Person {

	@Id
	private String ppsn;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="dateofbirth", nullable=false)
	private Date dateOfBirth;
	
	@Column(name="mobilePhone", nullable=false)
	private String mobilePhone;
	
	/**
	 * Attribute to save the date of creation of the record.
	 */
	@Column(name="createdDate", nullable=false)
	private Date createdDate;
	
	/**
	 * @return PPS Number
	 */
	public String getPpsn() {
		return ppsn;
	}
	
	/**
	 * set method of the ppsn attribute
	 * 
	 * @param PPS Number
	 */
	public void setPpsn(String ppsn) {
		this.ppsn = ppsn;
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set method of the name attribute
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * set method of the dateOfBirth attribute
	 * 
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * @return mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	/**
	 * set method of the mobilePhone attribute
	 * 
	 * @param mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	/**
	 * @return createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * set method of the createdDate attribute
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}

