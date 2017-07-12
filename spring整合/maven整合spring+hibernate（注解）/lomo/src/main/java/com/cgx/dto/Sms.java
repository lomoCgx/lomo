package com.cgx.dto;
// Generated 2017-7-12 11:18:15 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sms generated by hbm2java
 */
@Entity
@Table(name = "sms", catalog = "test")
public class Sms implements java.io.Serializable {

	private Integer id;
	private String username;
	private String sender;
	private String message;
	private String sendtime;
	private String isRead;

	public Sms() {
	}

	public Sms(String username, String sender) {
		this.username = username;
		this.sender = sender;
	}

	public Sms(String username, String sender, String message, String sendtime, String isRead) {
		this.username = username;
		this.sender = sender;
		this.message = message;
		this.sendtime = sendtime;
		this.isRead = isRead;
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

	@Column(name = "sender", nullable = false, length = 50)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "message", length = 1000)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "sendtime", length = 20)
	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	@Column(name = "isRead", length = 1)
	public String getIsRead() {
		return this.isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

}
