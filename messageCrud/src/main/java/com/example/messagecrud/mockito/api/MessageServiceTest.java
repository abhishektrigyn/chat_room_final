package com.example.messagecrud.mockito.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.messagecrud.dto.MessageDTO;
import com.example.messagecrud.dto.MessageInsertDTO;
import com.example.messagecrud.dto.UserMessageDTO;
import com.example.messagecrud.model.Message;
import com.example.messagecrud.model.User;
import com.example.messagecrud.repo.MessageRepoCustom;
import com.example.messagecrud.repo.UserRepoCustom;
import com.example.messagecrud.service.ImessageService;
import com.example.messagecrud.service.impl.MessageServiceImpl;

import jakarta.persistence.metamodel.EntityType;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

///@Service
@ExtendWith(MockitoExtension.class)

public class MessageServiceTest {

	@Mock
	private MessageRepoCustom messageRepo;
	@Mock
	private UserRepoCustom userRepo;
	@InjectMocks
	private MessageServiceImpl messageService;
	@Test
	public void deleteMessagesTest()
	{
		  final Message entity = new Message();
		  entity.setMessageId(120L);
		    Optional<Message> optionalEntityType = Optional.of(entity);
		     Mockito.when(messageRepo.findById(1L)).thenReturn(optionalEntityType);
		    // when
		     messageService.delete(optionalEntityType.get());
		    // then
		    Mockito.verify(messageRepo, times(1)).delete(entity);
		  
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
		
		given(messageRepo.validateUser(username, password))
		.willReturn(user);
		responseUser = messageService.validateUser(username, password);
		assertThat(responseUser).isNotNull();
		assertThat(responseUser.getUsername()).isEqualTo("abhishek");
		System.out.println("end");

	}
	@Test
	public void insertMessagesTest()
	{

		String username="abhishek";
		String password="test";
		Message msgObject=new  Message();
		String message="ANBCBCBCBC";
		///////////////////////////////////////////////////
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		MessageInsertDTO msgUserRes=new MessageInsertDTO();
		msgUserRes.setUsername(username);
		msgUserRes.setPassword(password);
		msgUserRes.setMessageId(String.valueOf(new Long(250)));
		msgUserRes.setMessage(message);
		
		Message inputMsg= new Message();
		inputMsg.setMessageId(9L);
		inputMsg.setData("ABCD");
		
		Message outputMsg= new Message();
		outputMsg.setMessageId(9L);
		outputMsg.setData("ABCD");
		//BDDMockito.given(messageService.insertMessages(user, message)).willReturn(msgUserRes);
		//BDDMockito.given(messageRepo.save(inputMsg)).willReturn(outputMsg);
        when(messageRepo.save(Mockito.any(Message.class))).thenReturn(outputMsg);
        inputMsg=  messageService.save(inputMsg);
		assertEquals(inputMsg, outputMsg);
        System.out.println("end");

	}
	
}
