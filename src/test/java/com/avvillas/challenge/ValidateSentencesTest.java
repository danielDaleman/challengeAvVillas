package com.avvillas.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avvillas.challenge.models.Sentences;
import com.avvillas.challenge.models.SentencesResponse;
import com.avvillas.challenge.service.IValidateWordsService;
import com.avvillas.challenge.service.implementation.ValidateSentencesService;
import com.avvillas.challenge.transversal.exception.BusinessException;

@ExtendWith(MockitoExtension.class)
class ValidateSentencesTest {
	
	@InjectMocks
	ValidateSentencesService service;		
	
	@Mock
	IValidateWordsService iServiceWords;
	
	private Sentences sentences;	
	
	@BeforeEach
	void init() throws BusinessException {				
		sentences = new Sentences();				
	}
	
	@Test
	void validateSentencesWithMatch() {
		try {				
			Mockito.when(iServiceWords.validateWords(Mockito.any())).thenReturn(true);
			sentences.setFraseUno("angela es conservadora");
			sentences.setFraseDos("ellos alegan que ella es muy conversadora");
			SentencesResponse response = service.validateSentences(sentences);
			assertTrue(response.isResponse());			
			assertEquals(3, response.getCount());
			assertEquals("angela, alegan| es, es| conservadora, conversadora| ",response.getWords());						
			
		} catch (BusinessException e) {
			assertTrue(false);	
		}
		
	}
	
	@Test
	void validateSentencesWithoutMatch() {
		try {
			
			sentences.setFraseUno("angela es conservadora");
			sentences.setFraseDos("challenge avvillas");
			SentencesResponse response = service.validateSentences(sentences);
			assertFalse(response.isResponse());			
			assertEquals(0, response.getCount());
			assertEquals("",response.getWords());						
			
		} catch (BusinessException e) {
			assertTrue(false);	
		}
		
	}

}
