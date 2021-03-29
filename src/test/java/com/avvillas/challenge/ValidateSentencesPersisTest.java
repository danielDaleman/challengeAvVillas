package com.avvillas.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avvillas.challenge.entitys.Message;
import com.avvillas.challenge.models.Sentences;
import com.avvillas.challenge.models.SentencesResponse;
import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.IValidateWordsService;
import com.avvillas.challenge.service.implementation.ValidateSentencesPersisService;
import com.avvillas.challenge.transversal.exception.BusinessException;

@ExtendWith(MockitoExtension.class)
class ValidateSentencesPersisTest {
	
	@InjectMocks
	ValidateSentencesPersisService service;		
	
	@Mock
	IValidateWordsService iServiceWords;
	
	@Mock
	MessageRepository messageRepository;
	
	private List<Message> messages;
	
	@BeforeEach
	void init() throws BusinessException {				
		messages = new ArrayList<>();
			
	}
	
	@Test
	void validateSentencesOk() {
		Message message = new Message();	
		message.setId(1L);
		message.setMensaje("lucia viaja");
		messages.add(message);
		
		message.setId(2L);
		message.setMensaje("viaja lucia");
		messages.add(message);
		
		message.setId(3L);
		message.setMensaje("ivaaj aicul");
		messages.add(message);
		
		when(messageRepository.findAll()).thenReturn(messages);
		
		try {
			when(iServiceWords.validateWords(Mockito.any())).thenReturn(true);
			SentencesResponse response = service.validateSentences();
			assertTrue(response.isResponse());
		} catch (BusinessException e) {
			assertTrue(false);			
		}				
	}
	
	@Test
	void validateSentencesNoOk() {
		Message message = new Message();	
		message.setId(1L);
		message.setMensaje("lucia viaja");
		messages.add(message);				
		
		when(messageRepository.findAll()).thenReturn(messages);
		
		try {			
			SentencesResponse response = service.validateSentences();
			assertTrue(response.isResponse());
		} catch (BusinessException e) {			
			assertEquals("Faltan frases por cargar, deben ser 3 y hay: 1", e.getMessage());			
		}				
	}

}
