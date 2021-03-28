package com.avvillas.challenge.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleSentence {
	
	@NotNull(message="La frase no puede ser null")
	@NotBlank(message="La frase no puede ser vacía")
	private String frase;
}
