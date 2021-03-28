package com.avvillas.challenge.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avvillas.challenge.models.MessageResponse;
import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.IGetMessage;
import com.avvillas.challenge.transversal.exception.BusinessException;

@Service
public class GetMessage implements IGetMessage{

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public List<MessageResponse> findAll() throws BusinessException {
		
		List<MessageResponse> messages = new ArrayList<>();
		
		var messageOp = messageRepository.findAll();
		
		messageOp.stream().forEach(item -> messages.add(modelmapper.map(item, MessageResponse.class)));
		
		
		return messages;
	}

}
