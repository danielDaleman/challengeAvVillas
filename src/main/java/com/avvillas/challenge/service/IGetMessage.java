package com.avvillas.challenge.service;

import java.util.List;

import com.avvillas.challenge.models.MessageResponse;
import com.avvillas.challenge.transversal.exception.BusinessException;

public interface IGetMessage {

	List<MessageResponse> findAll() throws BusinessException;

}
