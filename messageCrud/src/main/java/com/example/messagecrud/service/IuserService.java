package com.example.messagecrud.service;

import java.util.List;
import java.util.Set;

import com.example.messagecrud.dto.UserMessageDTO;
import com.example.messagecrud.model.Message;
import com.example.messagecrud.model.User;

public interface IuserService extends IcommonService {
	public Set<Message> getAllMessagesForUser(User validUser);
	public List<User> getAllUsers() ;
	public Set<Message> getHistoryData(User user);
	public UserMessageDTO getUserDtoWithMessage(User validUser);
	
}
