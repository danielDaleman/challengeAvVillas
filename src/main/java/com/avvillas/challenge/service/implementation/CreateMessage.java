package com.avvillas.challenge.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avvillas.challenge.entitys.Message;
import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.ICreateMessage;
import com.avvillas.challenge.transversal.exception.BusinessException;

@Service
public class CreateMessage implements ICreateMessage{

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public void create(String sentence) throws BusinessException {
		
		var messageOp = messageRepository.findAll();
		
		if(messageOp.size() >= 3) {
			throw new BusinessException("Ya existen los 3 mensajes registrados");
		}
		
		Message message = new Message();
		message.setMensaje(sentence);
		
		messageRepository.save(message);
	}

}
