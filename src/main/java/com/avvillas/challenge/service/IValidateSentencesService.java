package com.avvillas.challenge.service;

import com.avvillas.challenge.models.Sentences;
import com.avvillas.challenge.models.SentencesResponse;
import com.avvillas.challenge.transversal.exception.BusinessException;

public interface IValidateSentencesService {
	
	 SentencesResponse validateSentences(Sentences sentences) throws BusinessException;
	
}
