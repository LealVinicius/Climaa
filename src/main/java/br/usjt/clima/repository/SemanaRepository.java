package br.usjt.clima.repository;

import br.usjt.clima.model.Semana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SemanaRepository extends JpaRepository<Semana, Long> {

}


