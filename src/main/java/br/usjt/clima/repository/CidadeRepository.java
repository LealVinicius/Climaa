package br.usjt.clima.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

import br.usjt.clima.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	public Cidade findOneByLatitudeAndLongitude(Double latitude, Double longitude);
	public List<Cidade> findByNomeContainingIgnoreCase(String nome);
	
	@Async
	public Future<List<Cidade>> findByNome(String nome);
}
