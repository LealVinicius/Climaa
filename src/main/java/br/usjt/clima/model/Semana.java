package br.usjt.clima.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Semana {
	//Apenas para ilustrar o OneToOne, o correto seria fazer uma enumeração,
	//já que os dias da semana são fixos.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String dia;
}
