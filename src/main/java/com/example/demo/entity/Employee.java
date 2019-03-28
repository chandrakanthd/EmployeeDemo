package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * The Entity class for the Employee table in database
 * 
 * @author Chandra Kanth
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

	/**
	 * Id of the employee
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * The name of the employee
	 */
//	@NotBlank
	private String name;

	/**
	 * The employee code
	 */
//	@NotBlank
	private String code;

	/**
	 * Team that the employee is part of
	 */
//	@NotBlank
	private String team;

	/**
	 * The contact no. of the employee
	 */
//	@NotBlank
	private String phone;

	/**
	 * The email of the employee
	 */
//	@NotBlank
	private String email;

	/**
	 * The address of the employee
	 */
//	@NotBlank
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", name=" + name + ", code=" + code + ", team=" + team + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + "]";
	}

}
