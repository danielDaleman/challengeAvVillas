package com.avvillas.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.avvillas.challenge.models.Words;
import com.avvillas.challenge.service.IValidateWordsService;
import com.avvillas.challenge.transversal.exception.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping("/validateWords")
@Api(tags = "validateWords", value = "API para comparar palabras.")
@Slf4j
public class ValidateWordsController {
	
	@Autowired
	IValidateWordsService validateWordsService;
	
	@ApiOperation(value = "Compara dos palabras y retorna true/false, según el caso", response = Boolean.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)		
	public ResponseEntity<Boolean> validateWords(@RequestBody @Valid Words words) {		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(validateWordsService.validateWords(words));
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
}
