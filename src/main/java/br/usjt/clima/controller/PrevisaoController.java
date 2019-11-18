package br.usjt.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.clima.model.Cidade;
import br.usjt.clima.model.Forecast;
import br.usjt.clima.repository.CidadeRepository;
import br.usjt.clima.repository.PrevisaoRepository;
import br.usjt.clima.service.PrevisaoService;

@Controller
public class PrevisaoController {
	@Autowired
	private PrevisaoRepository previsaoRepo;
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private PrevisaoService previsaoService;
	
	@GetMapping("/previsoes")
	public ModelAndView listarPrevisoes() {
		ModelAndView mv = new ModelAndView("listar_previsoes");
		List<Cidade> cidades = cidadeRepo.findAll();
		mv.addObject("cidades", cidades);
		return mv;
	}
	
	@GetMapping(value = "/c", produces = MediaType.APPLICATION_JSON_VALUE)
	public Forecast consume() {
		Forecast forecast = previsaoService.obter();
		return forecast;
		//return previsaoService.raw();
	}
}
