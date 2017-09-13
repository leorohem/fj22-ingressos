package br.com.caelum.ingresso.rest;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.Rest.ImdbClient;
import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

	@Component
		public class ImdbClient {
	
	private Logger logger = Logger.getLogger (ImdbClient.class);	
	public Optional <DetalhesDoFilme> request (Filme filme) {
		
		RestTemplate client = new RestTemplate();
		
		String titulo = filme.getNome().replace("", "");
		
		String url = String.format("https://imdb-fj22.herokuapp.com/imdbtitle=%s",  titulo);
		
		try {
			
			DetalhesDoFilme detalheDoFilme = client.getForm
		}
		
	}

}
