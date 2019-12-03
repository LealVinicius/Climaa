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
	private PrevisaoService previsaoService;
	@Autowired
	private PrevTempoService prevService;

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

	//Busca por nome
	@PostMapping("/buscarNome")
	public ModelAndView buscarPorNome(String nome) {
		ModelAndView mv = new ModelAndView("listar_previsoes");
		mv.addObject(new Clima());
		List<Clima> climas = prevService.buscaCidade(nome);
		mv.addObject("climas", climas);
		return mv;
	}
	/*
	//Busca por latitude e longitude
    @PostMapping("/buscarLateLon")
    public ModelAndView buscarLateLon(double lat, double lon){
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Clima());
        List<Clima> tempos = prevService.buscaPorLatELon(lat,lon);
        mv.addObject("tempos", tempos);
        return mv;
    }
*/
}
