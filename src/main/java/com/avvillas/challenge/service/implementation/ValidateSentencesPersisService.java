package com.avvillas.challenge.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avvillas.challenge.models.SentencesResponse;
import com.avvillas.challenge.models.Words;
import com.avvillas.challenge.repository.MessageRepository;
import com.avvillas.challenge.service.IValidateSentencesPersisService;
import com.avvillas.challenge.service.IValidateWordsService;
import com.avvillas.challenge.transversal.exception.BusinessException;
import com.avvillas.challenge.util.ConverterUtil;


@Service
public class ValidateSentencesPersisService implements IValidateSentencesPersisService{
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private IValidateWordsService validateWordsService;
	
	
	private static boolean validate;
	private static Integer count;
	private static StringBuilder wordsMatch;
	
	@Override
	public SentencesResponse validateSentences() throws BusinessException {
		
		SentencesResponse response = new SentencesResponse();
		validate = false;
		count = 0;
		wordsMatch = new StringBuilder();
		
		var messageOp = messageRepository.findAll();
		
		if(messageOp.isEmpty() || messageOp.size()<3) {
			throw new BusinessException("Faltan frases por cargar, deben ser 3 y hay: " + messageOp.size());
		}
		
		var listaUno = ConverterUtil.convertSentenceToList(messageOp.get(0).getMensaje());
		var listaDos = ConverterUtil.convertSentenceToList(messageOp.get(1).getMensaje());
		var listaTres = ConverterUtil.convertSentenceToList(messageOp.get(2).getMensaje());
		
		validateLists(listaUno,listaDos);
		validateLists(listaUno,listaTres);
		validateLists(listaDos,listaTres);		
		
		response.setCount(count);
		response.setResponse(validate);
		response.setWords(wordsMatch.toString());
		
		return response;
	}
	
	private void validateLists(List<String> listaUno, List<String> listaDos) throws BusinessException {
		
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
	}
	
}
