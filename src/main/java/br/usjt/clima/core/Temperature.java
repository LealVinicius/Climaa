package br.usjt.clima.core;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Temperature implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date dataHora;
	@JsonAlias("temp_min")
	private Double tempMin;
	@JsonAlias("temp_max")
	private Double tempMax;
	private Double humidity;
	private String descricao;
	public String icon;
	
}
