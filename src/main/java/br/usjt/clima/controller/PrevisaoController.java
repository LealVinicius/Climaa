package br.usjt.clima.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.usjt.clima.core.Forecast;
import br.usjt.clima.model.Cidade;
import br.usjt.clima.model.Clima;
import br.usjt.clima.repository.CidadeRepository;
import br.usjt.clima.service.PrevTempoService;
import br.usjt.clima.service.PrevisaoService;

@Controller
public class PrevisaoController {

	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	// Classe da API
	private PrevisaoService previsaoService;
	@Autowired
	private PrevTempoService prevService;

	@PostMapping("/buscarCidade")
	public ModelAndView buscarCidade(String nome) {
		ModelAndView mv = new ModelAndView("lista_previsoes");
		mv.addObject(new Clima());
		List<Clima> tempos = prevService.buscaPorNome(nome);
		// Future<List<Tempo>> tempos = peridosService.buscarCidade(nome);
		mv.addObject("tempos", tempos);
		return mv;
	}

	/*
	 * @PostMapping("/buscarPorLatELong") public ModelAndView buscarLatELong(double
	 * latitude, double longitude) { ModelAndView mv = new
	 * ModelAndView("lista_tempo"); mv.addObject(new Cidade()); List<Clima> climas =
	 * prevService.findAllByCidade_LatitudeAndCidade_Longitude(latitude, longitude);
	 * mv.addObject("climas", climas); return mv;
	 * 
	 * }
	 */

	/*
	 * // Busca por nome
	 * 
	 * @PostMapping("/buscarNome") public ModelAndView buscarPorNome(String nome) {
	 * ModelAndView mv = new ModelAndView("listar_previsoes"); mv.addObject(new
	 * Clima()); List<Clima> climas = prevService.findAllByCidade_Nome(nome);
	 * mv.addObject("climas", climas); return mv; }
	 */

	@GetMapping("/previsoes")
	public ModelAndView listarPrevisoes() {
		ModelAndView mv = new ModelAndView("listar_previsoes");
		List<Cidade> cidades = cidadeRepo.findAll();
		mv.addObject("cidades", cidades);
		return mv;
	}

	// Busca por ID
	@GetMapping(value = "/buscarPrev/cidade/{cidadeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String consume(@PathVariable long cidadeId) {
		Cidade cidade = cidadeRepo.findById(cidadeId).get();
		Forecast forecast = previsaoService.obter(cidade);
		List<Clima> climas = previsaoService.toClimaList(forecast, cidade);
		previsaoService.saveClimas(climas);
		return "redirect:/previsoes";
	}

}
