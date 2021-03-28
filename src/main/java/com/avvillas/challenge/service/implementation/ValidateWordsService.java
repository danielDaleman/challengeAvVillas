package com.avvillas.challenge.service.implementation;

import org.springframework.stereotype.Service;

import com.avvillas.challenge.models.Words;
import com.avvillas.challenge.service.IValidateWordsService;
import com.avvillas.challenge.transversal.exception.BusinessException;
import com.avvillas.challenge.util.ConverterUtil;

@Service
public class ValidateWordsService implements IValidateWordsService{

	@Override
	public boolean validateWords(Words words) throws BusinessException {
		
		boolean validate = true;
		
		if(words.getPalabraUno().length() != words.getPalabraDos().length()) {
			throw new BusinessException("Las palabras deben tener la misma longitud");
		}
		
		var listaUno = ConverterUtil.convertStringToList(words.getPalabraUno());
		var listaDos = ConverterUtil.convertStringToList(words.getPalabraDos());
		
		for(Character item: listaUno){
			if(!listaDos.contains(item)) {
				validate = false;
			}
		};		
		
		return validate;
	}

}
