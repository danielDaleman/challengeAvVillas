package com.avvillas.challenge.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Message {
	
	@Id
	@GeneratedValue		
	private Long id;
	private String mensaje;
	
}
