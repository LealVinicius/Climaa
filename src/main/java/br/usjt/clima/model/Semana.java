package br.usjt.clima.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class Semana {
	//Apenas para ilustrar o OneToOne, o correto seria fazer uma enumeração, já que os dias da semana são fixos.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String dia;
}
