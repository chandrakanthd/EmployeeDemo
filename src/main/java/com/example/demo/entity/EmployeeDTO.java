package com.example.demo.entity;

/**
 * The Employee DTO class used to transfer data to and from frontend
 * 
 * @author Chandra Kanth
 *
 */
public class EmployeeDTO {

	/**
	 * Id of the employee
	 */
	private int id;

	/**
	 * The name of the employee
	 */
	private String name;

	/**
	 * The employee code
	 */
	private String code;

	/**
	 * Team that the employee is part of
	 */
	private String team;

	/**
	 * The contact no. of the employee
	 */
	private String phone;

	/**
	 * The email of the employee
	 */
	private String email;

	/**
	 * The address of the employee
	 */
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

}
