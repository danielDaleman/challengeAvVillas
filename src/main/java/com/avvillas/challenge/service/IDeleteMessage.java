package com.avvillas.challenge.service;

import com.avvillas.challenge.transversal.exception.BusinessException;

public interface IDeleteMessage {

	void deleteAll() throws BusinessException;

}
