package com.uxpsystems.assignment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id",updatable = false)
	private long id;
	
	
	@NotNull(message="username can not be null")
	@Column(name="user_name",unique = true)
	private String username;
	
	@NotNull(message="password can not be null")
	@Column(name="password")
	private String password;
	
	
	@Pattern(regexp="Activated|Deactivated")
	@Column(name="status",columnDefinition = "varchar(50) default 'Activated'")
	private String status;
	
	public User() {
		
	}
	
	public User(String username, String password, String status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@PrePersist
	public void prePersist() {
	    if(status == null) //We set default value in case if the value is not set yet.
	    	status = "Activated";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status + "]";
	}
	
}
