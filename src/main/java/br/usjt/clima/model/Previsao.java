package br.usjt.clima.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Previsao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Semana semana;
	private Date dataHora;
	private Double tempMinima;
	private Double tempMaxima;
	private Double umidade;
	private String descricao;
	
	@ManyToOne
	Cidade cidade;
	
}
