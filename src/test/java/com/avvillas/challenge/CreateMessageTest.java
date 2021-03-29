package com.avvillas.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avvillas.challenge.entitys.Message;
import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.implementation.CreateMessage;
import com.avvillas.challenge.transversal.exception.BusinessException;

@ExtendWith(MockitoExtension.class)
class CreateMessageTest {
	
	@InjectMocks
	CreateMessage service;
	
	@Mock
	MessageRepository messageRepository;
	
	private List<Message> messages;
	
	@BeforeEach
	void init() {
		messages = new ArrayList<>();
	}
	
	@Test
	void createOk() {
		when(messageRepository.findAll()).thenReturn(messages);		
		try {
			service.create("Mensaje nuevo");
			assertTrue(true);
		} catch (BusinessException e) {
			assertTrue(false);			
		}

	}
	
	@Test
	void createNoOk() {
		messages.add(new Message());
		messages.add(new Message());
		messages.add(new Message());
		when(messageRepository.findAll()).thenReturn(messages);		
		try {
			service.create("Mensaje nuevo");
			assertTrue(false);
		} catch (BusinessException e) {
			assertEquals("Ya existen los 3 mensajes registrados", e.getMessage());	
		}

	}

}
