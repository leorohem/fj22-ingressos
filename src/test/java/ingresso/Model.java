package ingresso;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

import org.junit.Test;

import List;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class Model {
	
	@Test
	public void deveRetornarFalseQuandoNaoCabe() {
		
		LocalTime duasEMeia = LocalTime.parse("14:30");
		Filme F1 = new Filme("Harry Poter", Duration.ofMinutes(120), "Aventura");
		
		Sala sala = new Sala("3D");
		
		Sessao s1 = new Sessao(duasEMeia,F1,sala);
		
		List<Sessao> sessaoExistents = (List) Arrays.asList(new Sessao(LocalTime.parse("13:00"), new Filme2("Anabelle"),
				sala), new Sessao(LocalTime.parse("20:00"), new Filme3("Codigo da Vinci"), sala),
				new Sessao (LocalTime.parse("10:00"), new Filme4("Velozes e Furiosos"), sala));
		
	}
}			
		

		
		
		
		
