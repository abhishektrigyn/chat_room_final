package com.example.messagecrud.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.messagecrud.dto.MessageDTO;
import com.example.messagecrud.dto.MessageInsertDTO;
import com.example.messagecrud.dto.UserMessageDTO;
import com.example.messagecrud.model.Message;
import com.example.messagecrud.model.User;
import com.example.messagecrud.repo.MessageRepoCustom;
import com.example.messagecrud.service.ImessageService;

@Service
public class MessageServiceImpl implements ImessageService{

	@Autowired
	private  MessageRepoCustom messageRepo;
@Override
public Message save(Message msg) {
	// TODO Auto-generated method stub
	return messageRepo.save(msg) ;
}

	@Override
	public MessageInsertDTO insertMessages(User user,String message)
	{
		String username=user.getUsername();
		String password=user.getPassword();
		Message persistMsg=null;

		Message msg=new Message();
		msg.setData(message);
		msg.setUsers(user);
		persistMsg=save(msg)  ;


		MessageInsertDTO msgUserRes=new MessageInsertDTO();
		msgUserRes.setUsername(username);
	///	msgUserRes.setPassword(password); prevented password from setting
		Optional optionalValue = Optional.ofNullable(persistMsg);
		if(optionalValue.isPresent()){  // check for value is present or not  
		msgUserRes.setMessageId(String.valueOf(persistMsg.getMessageId()));

		}else  
		{
			msgUserRes.setMessageId(null);
		}  
		msgUserRes.setMessage(message);
		return msgUserRes;
	}
	//	
@Override
public void delete(Message deletedMsg) {
	// TODO Auto-generated method stub
	messageRepo.delete(deletedMsg)  ;
}
	@Override
	public void deleteMessages(List<MessageDTO> message) {

		Message deletedMsg = null;
		for(MessageDTO tempMsg:message)
		{
			Long lid=Long.valueOf(tempMsg.getMessageId());
			deletedMsg=new Message(lid);
			delete(deletedMsg)  ;
		}
	}
	@Override
	public UserMessageDTO convertDeleteIdsToObject(UserMessageDTO msgDto) {
		// TODO Auto-generated method stub
		if(msgDto.getDeleteIds()!=null)
		{
			String deleteIds=msgDto.getDeleteIds();
			String[] msgArray=deleteIds.split(",");
			UserMessageDTO userMsgDtoReturn=new UserMessageDTO();
			List<MessageDTO> lstMessageDto=new ArrayList<>();
			for(String msgId:msgArray)
			{
				MessageDTO tmpMsgDto=new MessageDTO();
				tmpMsgDto.setMessageId(Integer.parseInt(msgId));
				lstMessageDto.add(tmpMsgDto);

			}
			userMsgDtoReturn.setMessages(lstMessageDto);
			return userMsgDtoReturn;

		}
		else
		{
			return null;
		}
	}

	@Override
	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return      messageRepo.validateUser(username, password);

	}

	@Override
	public User checkUser(String username) {
		// TODO Auto-generated method stub
		return messageRepo.checkUser(username);
	}

	@Override
	public UserMessageDTO deleteSingleOrMultipleObjects(UserMessageDTO messages) {
		// TODO Auto-generated method stub
		UserMessageDTO tmpUserMsgDto =	convertDeleteIdsToObject(messages);
		deleteMessages(tmpUserMsgDto.getMessages());
		//	ResponseEntity<UserMessageDTO> resUserMsgDto=MessageController(userMessage);
		return tmpUserMsgDto;
	}



}
