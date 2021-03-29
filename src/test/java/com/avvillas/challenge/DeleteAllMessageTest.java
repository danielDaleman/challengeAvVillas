package com.avvillas.challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.implementation.DeleteMessage;
import com.avvillas.challenge.transversal.exception.BusinessException;

@ExtendWith(MockitoExtension.class)
class DeleteAllMessageTest {	

	@InjectMocks
	DeleteMessage service;
	
	@Mock
	MessageRepository messageRepository;	
	
	@Test
	void test() {
		try {
			service.deleteAll();
			assertTrue(true);
		} catch (BusinessException e) {
			assertTrue(false);			
		}
	}

}
