package br.usjt.clima.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.clima.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	//fazer assíncrono
	public Cidade findOneByLatitudeAndLongitude(Double latitude, Double longitude);
	public List<Cidade> findByNome(String nome);
	public List<Cidade> findByNomeContainingIgnoreCase(String nome);
}
