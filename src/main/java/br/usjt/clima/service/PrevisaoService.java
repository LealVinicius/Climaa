package br.usjt.clima.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import br.usjt.clima.controller.Previsao;
import br.usjt.clima.model.Clima;
import br.usjt.clima.model.Forecast;

@Service @ResponseBody
public class PrevisaoService {
	private final String URL_PREV = "https://samples.openweathermap.org/data/2.5/forecast?q=";
	private final String APP_ID = "be8b5a409db5a652138d22f3a50368f9";
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private String urlPrev(String city) {
		return URL_PREV + city + "&appid=" + APP_ID;
	}

	@Bean
	public Forecast obter() {
		RestTemplate restTemplate = new RestTemplate();
		Forecast prev = restTemplate.getForObject(
				urlPrev("Sao%20Paulo"), Forecast.class);
//		return prev.getPrevisoes().stream().map(Previsao::getClima).collect(Collectors.toList());
//		List<Clima> climas = new ArrayList<>();
//		prev.getPrevisoes().forEach(p -> climas.add(p.getClima()));
				//);stream().map(Previsao::getClima).collect(Collectors.toList());
		return prev;
	}

	public String raw() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(urlPrev("Sao%20Paulo"), String.class);
	}

}
