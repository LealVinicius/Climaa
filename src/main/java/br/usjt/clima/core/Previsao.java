package br.usjt.clima.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Previsao {
	long dt;
	@JsonAlias("main")
	Temperature temperature;
	@JsonAlias("weather")
	List<Weather> weathers;
}
