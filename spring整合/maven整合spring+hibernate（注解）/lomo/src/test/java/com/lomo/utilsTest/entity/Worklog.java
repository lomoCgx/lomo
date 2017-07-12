package com.lomo.utilsTest.entity;
// Generated 2017-7-12 11:18:15 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Worklog generated by hbm2java
 */
@Entity
@Table(name = "worklog", catalog = "test")
public class Worklog implements java.io.Serializable {

	private Integer id;
	private String username;
	private Integer year;
	private Integer month;
	private Integer day;
	private String title;
	private String description;
	private String logtime;

	public Worklog() {
	}

	public Worklog(String username) {
		this.username = username;
	}

	public Worklog(String username, Integer year, Integer month, Integer day, String title, String description,
			String logtime) {
		this.username = username;
		this.year = year;
		this.month = month;
		this.day = day;
		this.title = title;
		this.description = description;
		this.logtime = logtime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "year")
	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name = "month")
	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@Column(name = "day")
	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "logtime", length = 20)
	public String getLogtime() {
		return this.logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

}
