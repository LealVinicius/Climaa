package br.usjt.clima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.usjt.clima.model.Clima;
import br.usjt.clima.repository.PrevisaoRepository;

public class PrevTempoService {

	@Autowired
	PrevisaoRepository prevRepo;

	public void salvar(Clima clima) {
		prevRepo.save(clima);
	}

	public List<Clima> buscaCidade(String nome) {
		return prevRepo.buscaPorNome(nome);
	}

	public List<Clima> listarTodos() {
		return prevRepo.findAll();
	}
	public List<Clima> buscaPorLatELon(double latitude, double longitude) {
		return prevRepo.buscaPorLatELon(latitude, longitude);
	}
}
