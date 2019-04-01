package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "logging")
public class Logging {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String action;

	private int userId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creDt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreDt() {
		return creDt;
	}

	public void setCreDt(Date creDt) {
		this.creDt = creDt;
	}

	@Override
	public String toString() {
		return "Logging [id=" + id + ", action=" + action + ", userId=" + userId + ", creDt=" + creDt + "]";
	}

}
