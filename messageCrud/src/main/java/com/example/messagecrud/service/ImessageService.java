package com.example.messagecrud.service;

import java.util.List;

import com.example.messagecrud.dto.MessageDTO;
import com.example.messagecrud.dto.MessageInsertDTO;
import com.example.messagecrud.dto.UserMessageDTO;
import com.example.messagecrud.model.Message;
import com.example.messagecrud.model.User;

public interface ImessageService extends IcommonService {
	public MessageInsertDTO insertMessages(User userDto,String message);
	public void deleteMessages(List<MessageDTO> messages);
	
	public UserMessageDTO convertDeleteIdsToObject(UserMessageDTO messages);
	public UserMessageDTO deleteSingleOrMultipleObjects(UserMessageDTO messages);
    public void delete(Message deletedMsg);
    public Message save(Message msg);
	
}
