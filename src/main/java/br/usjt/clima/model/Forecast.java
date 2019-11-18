package br.usjt.clima.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.usjt.clima.controller.Previsao;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Forecast {
	 private String cod;
	 private float message;
	 private float cnt;
	 @JsonAlias("list")
	 List<Previsao> previsoes;
	 Cidade cidade;
}
