package com.example.messagecrud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.messagecrud.dto.MessageDTO;
import com.example.messagecrud.dto.UserMessageDTO;
import com.example.messagecrud.model.Message;
import com.example.messagecrud.model.User;
import com.example.messagecrud.repo.UserRepoCustom;
import com.example.messagecrud.service.IuserService;


@Service
public class UserServiceImpl implements IuserService{
	
	@Autowired
	UserRepoCustom userRepo;
	
@Override
	public Set<Message> getAllMessagesForUser(User validUser)
	{
//		String username =userDto.getUsername();
//		String password=userDto.getPassword();
//		User validUser=userRepo.validateUser(username, password);
//	
    	Set<Message> messages=null;
        if(validUser!=null)
        {
        	messages=getHistoryData(validUser);
            

        }
       return messages;
	}
	public List<User> getAllUsers() {
		//return userRepo.validateUser(username, password);
		return userRepo.findAll();
		
	}
	
	@Override	
	public Set<Message> getHistoryData(User user) {
		Optional<User> dbUser=	userRepo.findById(user.getUserId());
		if(dbUser.isPresent())
		{
			User u=dbUser.get();
			Set set =u.getMessages();
			return set;
		}
		else
		{
			return null;
		}

	//return null;
	}
	@Override
	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return userRepo.validateUser(username, password);
	}
	@Override
	public User checkUser(String username) {
		// TODO Auto-generated method stub
		return userRepo.checkUser(username);
	}
	@Override
	public UserMessageDTO getUserDtoWithMessage(User validUser) {
		// TODO Auto-generated method stub
		UserMessageDTO userDtoRes = null;
		if(validUser!=null)
		{
			try {
				 userDtoRes=new UserMessageDTO();
				userDtoRes.setUsername(validUser.getUsername());
				// prevented password from setting
				//userDtoRes.setPassword(validUser.getPassword());
				List<MessageDTO> lstMsg=new ArrayList<>();
				for(Message msg:validUser.getMessages())
				{
					MessageDTO msgDto=new MessageDTO();
					msgDto.setMessageId(Integer.parseInt(String.valueOf(msg.getMessageId())));
					msgDto.setMessage(msg.getData());
					lstMsg.add(msgDto);
				}
				userDtoRes.setMessages(lstMsg)		;
				userDtoRes.setValidUser("YES");
				//usrDto= new ResponseEntity<>(userDtoRes, HttpStatus.OK);
				// return ResponseEntity.ok().build();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return userDtoRes;
			}
		else
		{
			 userDtoRes=new UserMessageDTO();
			 userDtoRes.setUsername(validUser.getUsername());
			 userDtoRes.setValidUser("NO");
			

		}
		return userDtoRes;
}
	

}
