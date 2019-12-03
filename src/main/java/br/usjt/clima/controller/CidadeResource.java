package br.usjt.clima.controller;

import java.net.URI;
import java.util.List;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.clima.model.Cidade;
import br.usjt.clima.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	@Autowired
	private CidadeRepository cidadeRepo;

	@GetMapping("/lista")
	public List<Cidade> todas() {
		return cidadeRepo.findAll();
	}

	@GetMapping("/latlong")
	public Cidade buscaCidade(@PathVariable double latitude, double longitude) {
		return cidadeRepo.findOneByLatitudeAndLongitude(56.0, 25.0);
	}

	@GetMapping("/{id}")
	public Cidade buscarPeloId(@PathVariable Long id) {
		return cidadeRepo.getOne(id);
	}

	@GetMapping("S")
	public Future<List<Cidade>> buscarPelaLetra(@PathVariable String nome) {
		return cidadeRepo.findByNome("S");
	}

	// TODO: Listar todas as cidades cujo nome começa com uma letra específica
	// TODO: Obter uma cidade por sua latitude e longitude

	@PostMapping("/salvar")
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade c = cidadeRepo.save(cidade);
		c.setNome("Bahia");
		c.setLatitude(45.2);
		c.setLongitude(53.6);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(c.getId())
				.toUri();
		return ResponseEntity.created(uri).body(c);
	}

}
