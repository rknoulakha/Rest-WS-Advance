package com.test.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "User")
@XmlType(propOrder = { "id", "name", "profession", "doj", "address" })
public class User {

	private long id;
	private String name;
	private Date doj;
	private String profession;
	private UserAddress address;

	public User() {

	}

	public User(long id, String name, String profession, UserAddress address) {
		super();
		this.id = id;
		this.name = name;
		this.doj = new Date();
		this.profession = profession;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	@XmlElement
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Date getDoj() {
		return doj;
	}

	@XmlElement(name="DOB")
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getProfession() {
		return profession;
	}

	@XmlElement
	public void setProfession(String profession) {
		this.profession = profession;
	}

	public UserAddress getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(UserAddress address) {
		this.address = address;
	}

}
