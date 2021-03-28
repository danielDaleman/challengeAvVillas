package com.avvillas.challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avvillas.challenge.models.Words;
import com.avvillas.challenge.service.implementation.ValidateWordsService;
import com.avvillas.challenge.transversal.exception.BusinessException;

@ExtendWith(MockitoExtension.class)
class ValidateWordsTest {
	
	@InjectMocks
	ValidateWordsService service;
	
	private Words palabras;
	
	@BeforeEach
	void init() {
		palabras = new Words();
	}
	
	@Test
	void validateLongitudNoIguales() {
		
		palabras.setPalabraUno("PalabraMasLarga");
		palabras.setPalabraDos("PalabraLarga");
		
		try {
			service.validateWords(palabras);			
		} catch (BusinessException e) {		
			assertEquals("Las palabras deben tener la misma longitud", e.getMessage());			
		}
		
	}
	
	@Test
	void validatePalabrasNoOk() {		
		palabras.setPalabraUno("Army");
		palabras.setPalabraDos("mary");		
		try {
			boolean reponse = service.validateWords(palabras);
			assertFalse(reponse);
			
			palabras.setPalabraUno("Mary");
			palabras.setPalabraDos("lary");
			reponse = service.validateWords(palabras);
			assertFalse(reponse);
			
			palabras.setPalabraUno("test");
			palabras.setPalabraDos("lary");
			reponse = service.validateWords(palabras);
			assertFalse(reponse);
			
		} catch (BusinessException e) {		
			assertTrue(false);		
		}
		
	}
	
	@Test
	void validatePalabrasOk() {		
		palabras.setPalabraUno("army");
		palabras.setPalabraDos("mary");		
		try {
			boolean reponse = service.validateWords(palabras);
			assertTrue(reponse);						
			
		} catch (BusinessException e) {		
			assertTrue(false);		
		}
		
	}

}
