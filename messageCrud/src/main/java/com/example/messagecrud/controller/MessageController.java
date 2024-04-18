package com.example.messagecrud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.messagecrud.dto.MessageDTO;
import com.example.messagecrud.dto.MessageInsertDTO;
import com.example.messagecrud.dto.UserMessageDTO;
import com.example.messagecrud.exception.MessageNotFoundException;
import com.example.messagecrud.exception.UserNotfoundException;
import com.example.messagecrud.model.Message;
import com.example.messagecrud.model.User;
import com.example.messagecrud.service.IuserService;
import com.example.messagecrud.service.impl.MessageServiceImpl;



@RestController
@RequestMapping("/crud")
public class MessageController {

	MessageServiceImpl messageService;
	public MessageController(MessageServiceImpl messageService) {
		this.messageService=messageService;
	}

	@Autowired
	private IuserService userRepoImpl;

	@GetMapping(value="/getallusers",produces={ "application/json" })
	public List<User> getAllUsers()
	{
		//Optional<User> user = userRepo.findById(id);
	List<User> lstUser=userRepoImpl.getAllUsers();
		if(lstUser!=null)
		{
			return lstUser;
		}
		else
		{
			lstUser=new ArrayList<>();
			return lstUser;

		}
	}


	// @GetMapping(value="/validateUser",produces = {"application/json"},consumes= {"application/json"})
	@PostMapping(value="/validateuser")
	public ResponseEntity<UserMessageDTO> MessageController(@RequestBody UserMessageDTO user)

	{
		String username=user.getUsername();
		String password=user.getPassword();
		User validUser= userRepoImpl.validateUser(username, password);
		UserMessageDTO responseUserMessageDto=userRepoImpl.getUserDtoWithMessage(validUser);
		ResponseEntity<UserMessageDTO> usrDto = new ResponseEntity<>(responseUserMessageDto, HttpStatus.OK);
		return usrDto;
	}

	@GetMapping(value="/getusermessage",produces = {"application/json"},consumes= {"application/json"})
	// public ResponseEntity<Set<Message>> getAllMessagesForUser(@PathVariable String username,@PathVariable String password)
	public ResponseEntity<Set<Message>> getAllMessagesForUser(@RequestBody UserMessageDTO user)
	{
		//Optional<User> user = userRepo.findById(id);
		if(userRepoImpl.checkUser(user.getUsername())!=null)
		{
			User validUser=userRepoImpl.validateUser(user.getUsername(), user.getPassword());
			if(validUser!=null)
			{
				Set<Message> messages=userRepoImpl.getAllMessagesForUser(validUser);
				if(messages!=null)
				{
					//messages=userRepoImpl.getHistoryData(validUser);
					return new ResponseEntity<>(messages, HttpStatus.OK);

				}
				else
				{
					// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					throw new MessageNotFoundException("This user has no messages ");


				}
			}
			else
			{
				// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				throw new UserNotfoundException("Check credentials");

			}
		}
		else
		{
			throw new UserNotfoundException("Not a valid user");

		}
	}

	@PostMapping(value="/insertmessage",produces = {"application/json"},consumes= {"application/json"})
	public ResponseEntity<MessageInsertDTO> insertMessages(@RequestBody MessageInsertDTO msgUserDto)

	{//Optional<User> user = userRepo.findById(id);
		if(messageService.checkUser(msgUserDto.getUsername())!=null)
		{
			User validUser=messageService.validateUser(msgUserDto.getUsername(), msgUserDto.getPassword());
			if(validUser!=null)
			{
				MessageInsertDTO resUsrMsgDto=messageService.insertMessages(validUser,msgUserDto.getMessage());
				return new ResponseEntity<>(resUsrMsgDto, HttpStatus.OK);
			}
			else {
				throw new UserNotfoundException("Check credentials");
			}
		}
		else
		{
			throw new UserNotfoundException("Not a valid user");

		}
	}

	@PostMapping("/deletemessage")
	public ResponseEntity<UserMessageDTO> deleteMessages(@RequestBody UserMessageDTO userMessage)
	{
		if(messageService.checkUser(userMessage.getUsername())!=null)
		{
			//Optional<User> user = userRepo.findById(id);
			User validUser=messageService.validateUser(userMessage.getUsername(), userMessage.getPassword());
			if(validUser!=null)
			{
				UserMessageDTO tmpDeleteDto=	messageService.deleteSingleOrMultipleObjects(userMessage);
	            ResponseEntity<UserMessageDTO> resUserMsgDto=MessageController(userMessage);
				return resUserMsgDto;
			}
	    	else
			{
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}
		}

		else
		{
			throw new UserNotfoundException("Not a valid user");

		}
	}


}
