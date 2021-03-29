package com.avvillas.challenge;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.avvillas.challenge.entitys.Message;
import com.avvillas.challenge.models.MessageResponse;
import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.implementation.GetMessage;
import com.avvillas.challenge.transversal.exception.BusinessException;

@ExtendWith(MockitoExtension.class)
class FindAllMessageTest {
	
	@InjectMocks
	GetMessage service;
	
	@Mock
	MessageRepository messageRepository;
	
	@Mock
	ModelMapper modelmapper;
	
	private List<Message> messages;
	
	@BeforeEach
	void init() {		
		messages = new ArrayList<>();		
	}
	
	@Test
	void findAll() {
		Message mensaje = new Message();
		mensaje.setId(1L);
		mensaje.setMensaje("mensaje");
		messages.add(mensaje);
		messages.add(mensaje);
		messages.add(mensaje);
		when(messageRepository.findAll()).thenReturn(messages);
		try {
			List<MessageResponse> response = service.findAll();
			assertEquals(3, response.size());
		} catch (BusinessException e) {
			assertTrue(false);
		}
	}

}
