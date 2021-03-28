package com.avvillas.challenge.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sentences {
	@NotNull(message="La frase uno no puede ser null")
	@NotBlank(message="La frase uno no puede ser vacía")
	private String fraseUno;
	@NotNull(message="La frase dos no puede ser null")
	@NotBlank(message="La frase dos no puede ser vacía")
	private String fraseDos;
}
