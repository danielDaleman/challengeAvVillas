package com.avvillas.challenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.avvillas.challenge.models.MessageResponse;
import com.avvillas.challenge.models.SentencesResponse;
import com.avvillas.challenge.models.SimpleSentence;
import com.avvillas.challenge.service.ICreateMessage;
import com.avvillas.challenge.service.IDeleteMessage;
import com.avvillas.challenge.service.IGetMessage;
import com.avvillas.challenge.service.IValidateSentencesPersisService;
import com.avvillas.challenge.transversal.exception.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping("/validateSentencesPersistent")
@Api(tags = "validateSentencesPersistent", value = "API para comparar frases con persistencia.")
@Slf4j
public class ValidateSentencesPersisController {
	
	@Autowired
	private ICreateMessage createMessage;
	
	@Autowired
	private IValidateSentencesPersisService validateSentencesPersisService;
	
	@Autowired
	private IGetMessage getMessage;
	
	@Autowired
	private IDeleteMessage deleteMessage;	
	
	@ApiOperation(value = "Cargar frase para evaluar", response = SentencesResponse.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void createMessage(@RequestBody @Valid SimpleSentence sentence) {
		try {
			createMessage.create(sentence.getFrase());
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@ApiOperation(value = "Calcula las coincidencias de las frases cargadas en BD", response = SentencesResponse.class)
	@GetMapping(path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<SentencesResponse> validateSentences() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(validateSentencesPersisService.validateSentences());
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@ApiOperation(value = "Consulta todos los mensajes registrados en el sistema", response = MessageResponse.class)
	@GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<MessageResponse>> findAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(getMessage.findAll());
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@ApiOperation(value = "Elimina todos los mensajes registrados en el sistema")
	@DeleteMapping(path = "/deleteAll")	
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		try {
			deleteMessage.deleteAll();
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
}
