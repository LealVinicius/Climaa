package br.usjt.clima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.clima.model.Clima;
import br.usjt.clima.repository.PrevisaoRepository;

@Service
public class PrevTempoService {

	@Autowired
	PrevisaoRepository prevRepo;

	public void salvar(Clima clima) {
		prevRepo.save(clima);
	}

	public List<Clima> buscaPorNome(String nome) {
		return prevRepo.buscaPorNome(nome);
	}

	public List<Clima> listarTodos() {
		return prevRepo.findAll();
	}
	
	//public List<Clima> findAllByCidade_LatitudeAndCidade_Longitude(double latitude, double longitude) {
	//	return prevRepo.findAllByCidade_LatitudeAndCidade_Longitude(latitude, longitude);
	//}
}
