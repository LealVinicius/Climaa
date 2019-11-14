package br.usjt.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.clima.model.Previsao;
import br.usjt.clima.repository.PrevisaoRepository;

@Controller
public class PrevisaoController {
	@Autowired
	private PrevisaoRepository previsaoRepo;
	
	@GetMapping("/previsoes")
	public ModelAndView listarPrevisoes() {
		ModelAndView mv = new ModelAndView("listar_previsoes");
		List<Previsao> previsoes = previsaoRepo.findAll();
		mv.addObject("previsoes", previsoes);
		return mv;
	}
}
