package br.usjt.clima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.clima.model.Previsao;

public interface PrevisaoRepository extends JpaRepository<Previsao, Long> {

}
