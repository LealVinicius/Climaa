package br.usjt.clima.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.usjt.clima.model.Cidade;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
//    @Query("select c from Cidade c where upper(c.nome) like :nome% or lower(c.nome) like :nome% ")
  //  public List<Cidade> findAllByNomeIgnoreCase(@Param("nome") String nome);

 //   @Query("select c from Cidade c where c.latitude = :latitude and c.longitude = :longitude")
 //   public List<Cidade> findAllByLatitudeAndLongitude(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
    
   public Cidade findOneByLatitudeAndLongitude(double latitude, double longitude);
    //public List<Cidade> findByNomeContainingIgnoreCase(String nome);
    
  //  @Async
   // public Future<List<Cidade>> findByName(String nome);
}
