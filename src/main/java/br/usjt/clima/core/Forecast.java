package br.usjt.clima.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Forecast {
	 private String cod;
	 private float message;
	 private float cnt;
	 @JsonAlias("list")
	 List<Previsao> previsoes;
}
