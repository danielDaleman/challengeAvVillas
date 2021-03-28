package com.avvillas.challenge.service;

import com.avvillas.challenge.models.Words;
import com.avvillas.challenge.transversal.exception.BusinessException;

public interface IValidateWordsService {
	
	boolean validateWords(Words words) throws BusinessException;
}
