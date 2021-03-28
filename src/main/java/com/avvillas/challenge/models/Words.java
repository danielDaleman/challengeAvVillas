package com.avvillas.challenge.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Words {
	@NotNull(message="La palabra uno no puede ser null")
	@NotBlank(message="La palabra uno no puede ser vacía")
	private String palabraUno;
	@NotNull(message="La palabra dos no puede ser null")
	@NotBlank(message="La palabra dos no puede ser vacía")
	private String palabraDos;
}
