package br.usjt.clima.controller;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.usjt.clima.model.Clima;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Previsao {
	long dt;
	@JsonAlias("main")
	Clima clima;
}
