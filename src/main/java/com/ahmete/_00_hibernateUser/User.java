package com.ahmete._00_hibernateUser;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="tbluser")
public class User {
	@Id // :Pk oldugunu belirtir
	@GeneratedValue(strategy = GenerationType.IDENTITY) //serial'a denk gelen strategy budur.
	private Long id;
	@Column(name ="ad",length=30,columnDefinition = "")
	private String name;
	private String surname;
	@Transient //tabloda kolon olarak tutulması istenmeyen fieldar varsa @Transient ile işaretlenebilir
	private  String adsoyad;
	
	private String email;
	private String username;
	private String password;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dob;
	
	public User() {
	}
	
	public User(String name, String surname, String email, String username, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public User(Long id, String name, String surname, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}