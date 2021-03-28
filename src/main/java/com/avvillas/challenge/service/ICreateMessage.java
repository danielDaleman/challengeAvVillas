package com.avvillas.challenge.service;

import com.avvillas.challenge.transversal.exception.BusinessException;

public interface ICreateMessage {

	public void create(String sentence) throws BusinessException;

}
