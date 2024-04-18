package com.example.messagecrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Message")
public class Message {
	

@Id
@Column(name="MESSAGEID")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long messageId;

//private Long userId;
public Long getMessageId() {
	return messageId;
}
public void setMessageId(Long messageId) {
	this.messageId = messageId;
}
//private String name;
@Column(name = "CONTENT")
private String data;
public Message() {
	// TODO Auto-generated constructor stub
}
public Message(Long messageId) {
	// TODO Auto-generated constructor stub
	//this.name=name;
	this.messageId=messageId;
	
}
@ManyToOne(cascade = {CascadeType.ALL})
//@JoinColumn(name = "USER_ID",nullable=false)
@JoinColumn(name = "USERID")
private User users;	

@JsonBackReference
public User getUsers() {
	return users;
}
public void setUsers(User users) {
	this.users = users;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}

//public Long getUserId() {
//	return userId;
//}
//public void setUserId(Long userId) {
//	this.userId = userId;
//}
//@Column(name = "USER_ID")
//private Long userId;
//
}
