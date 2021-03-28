package com.avvillas.challenge.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avvillas.challenge.models.Sentences;
import com.avvillas.challenge.models.SentencesResponse;
import com.avvillas.challenge.models.Words;
import com.avvillas.challenge.service.IValidateSentencesService;
import com.avvillas.challenge.service.IValidateWordsService;
import com.avvillas.challenge.transversal.exception.BusinessException;
import com.avvillas.challenge.util.ConverterUtil;

@Service
public class ValidateSentencesService implements IValidateSentencesService{

	@Autowired
	private IValidateWordsService validateWordsService;
	
	@Override
	public SentencesResponse validateSentences(Sentences sentences) throws BusinessException {
		 
		SentencesResponse response = new SentencesResponse();
		boolean validate = false;
		Integer count = 0;
		StringBuilder wordsMatch = new StringBuilder();
		
		var listaUno = ConverterUtil.convertSentenceToList(sentences.getFraseUno());
		var listaDos = ConverterUtil.convertSentenceToList(sentences.getFraseDos());
		
		for(String palabraUno: listaUno) {
			for(String palabraDos: listaDos) {				
				if(palabraUno.length() == palabraDos.length()) {
					Words words = new Words();
					words.setPalabraUno(palabraUno);
					words.setPalabraDos(palabraDos);
					if(validateWordsService.validateWords(words)) {
						count ++;
						validate = true;
						wordsMatch.append(palabraUno + ", " + palabraDos + "| ");
					}
				}							
			}
		}
		
		response.setCount(count);
		response.setResponse(validate);
		response.setWords(wordsMatch.toString());
		
		return response;
	}

}
