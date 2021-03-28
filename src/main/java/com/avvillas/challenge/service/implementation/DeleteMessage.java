package com.avvillas.challenge.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.IDeleteMessage;
import com.avvillas.challenge.transversal.exception.BusinessException;

@Service
public class DeleteMessage implements IDeleteMessage{
	
	@Autowired
	private MessageRepository messageRepository;	
	
	@Override
	public void deleteAll() throws BusinessException {
		messageRepository.deleteAll();		
	}

}
