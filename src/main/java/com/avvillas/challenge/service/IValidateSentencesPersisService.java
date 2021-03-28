package com.avvillas.challenge.service;

import com.avvillas.challenge.models.SentencesResponse;
import com.avvillas.challenge.transversal.exception.BusinessException;

public interface IValidateSentencesPersisService {

	SentencesResponse validateSentences() throws BusinessException;

}
