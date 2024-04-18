package com.example.messagecrud.mockito.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.messagecrud.model.Message;
import com.example.messagecrud.model.User;
import com.example.messagecrud.repo.MessageRepoCustom;
import com.example.messagecrud.repo.UserRepoCustom;
import com.example.messagecrud.service.impl.MessageServiceImpl;
import com.example.messagecrud.service.impl.UserServiceImpl;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepoCustom userRepo;
	@InjectMocks
	private UserServiceImpl userService;
	@Test
	public void getAllMessagesForUser()
	{
		try
		{
		User validUser = new User();
		validUser.setUsername("abhishek");
		validUser.setPassword("test");
		validUser.setMessages(null);
		validUser.setUserId(1L);
		
		Message m1=new Message();
		m1.setUsers(validUser);
		m1.setMessageId(122L);
		m1.setData("HI");
        
		Message m2=new Message();
		m2.setUsers(validUser);
		m2.setMessageId(123L);
		m2.setData("HELLO");
		Set<Message> set=new HashSet<>();
		set.add(m1);
		set.add(m2);
		validUser.setMessages(set);
		//System.out.println(msgSet);
		//BDDMockito.given(userRepo.findById(anyLong()))(Optional.of(validUser));
		when(userRepo.findById(anyLong())).thenReturn(Optional.of(validUser));

		Set<Message> returnSet=userService.getHistoryData(validUser);
		assertEquals(returnSet, set);
		System.out.println("end");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
public void getAllUsers() {
		//return userRepo.validateUser(username, password);

List<User> userList= new ArrayList<>();
User u1=new User();
u1.setUsername("abhishek");
u1.setPassword("test");
Message m1=new Message();
m1.setUsers(u1);
m1.setMessageId(122L);
m1.setData("HI");

Message m2=new Message();
m2.setUsers(u1);
m2.setMessageId(123L);
m2.setData("HELLO");
Set<Message> set1=new HashSet<>();
set1.add(m1);
set1.add(m2);
u1.setMessages(set1);
userList.add(u1);
//////////////////

User u2=new User();
u2.setUsername("abhishek");
u2.setPassword("test");
Message m3=new Message();
m3.setUsers(u2);
m3.setMessageId(122L);
m3.setData("HI");

Message m4=new Message();
m4.setUsers(u2);
m4.setMessageId(123L);
m4.setData("HELLO");
Set<Message> set2=new HashSet<>();
set2.add(m3);
set2.add(m4);
u2.setMessages(set2);
userList.add(u2);

BDDMockito.given(userRepo.findAll()).willReturn(userList);
List<User> expectedList=userService.getAllUsers();
assertEquals(userList, expectedList);
System.out.println("end");
	}
	
	@Test
	public void validateUserTest()
	{
		String username="abhishek";
		String password="test";
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		User responseUser = new User();
		
		given(userService.validateUser(username, password))
		.willReturn(user);
		responseUser = userService.validateUser(username, password);
		assertThat(responseUser).isNotNull();
		assertEquals(user,responseUser);
		assertThat(responseUser.getUsername()).isEqualTo("abhishek");
		System.out.println("end");

	}
	@Test
	public void checkUserTest()
	{
		String username="abhishek";
		String password="test";
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		User responseUser = new User();
		
		given(userService.checkUser(username))
		.willReturn(user);
		responseUser = userService.checkUser(username);
		assertThat(responseUser).isNotNull();
		assertEquals(user,responseUser);
		assertThat(responseUser.getUsername()).isEqualTo("abhishek");
		System.out.println("end");

	}
}
