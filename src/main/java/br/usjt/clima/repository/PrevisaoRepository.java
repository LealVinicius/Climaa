package br.usjt.clima.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.usjt.clima.model.Clima;


public interface PrevisaoRepository extends JpaRepository<Clima, Long> {
   	@Async
    @Query("select p from Tempo p inner join p.cidade c where c.id = p.id and upper(c.nome) = upper(:nome)")
    List<Clima> findAllByCidade_Nome(@Param("nome") String nome);
	
	@Async
    @Query("select p from Tempo p inner join p.cidade c where c.id = p.id and c.latitude = :latitude and c.longitude = :longitude")
    List<Clima> findAllByCidade_LatitudeAndCidade_Longitude(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
	
	List<Clima> findAllByCidade_NomeIgnoreCase(String nome);

    List<Clima> buscaPorNome (@Param("nome") String nome);

    List<Clima> buscaPorLatELon(@Param("latitude") Double latitude,@Param("longitude") Double longitude);
    
}
