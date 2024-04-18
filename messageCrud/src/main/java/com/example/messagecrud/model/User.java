package com.example.messagecrud.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERID")
	private Long userId;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PWD")
	private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="USERID")
//	private Set<Message> messages;
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "users")
//	@OneToMany(targetEntity = Message.class,cascade=CascadeType.ALL)

//	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="USER_ID")
    @OrderBy("messageId ASC") 

	private Set<Message> messages;
	//private List<Message> messages;



	public Long getUserId() {
		return userId;
	}
	 @JsonManagedReference
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
