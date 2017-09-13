package br.com.caleum.ingresso.validacao;

import java.awt.List;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

import javax.persistence.Entity;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.validacao.GerenciadorDeSessao;

public class GerenciadorDeSessaoTest {
	
	@Entity
		public class Sala {
		private BigDecimal preco;
	}
	
		
		
		public Sala(String nome, BigDecimal preco) {
			this.nome = nome;
			this.preco = preco;
		}
		
	@Entity
	public class Filme {
		private BigDecimal preco;
		
		
		
		
	}
	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario () {
		Filme filme = new Filme ("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		LocalTime horario = LocalTime.now();
		
		Sala sala = new Sala ("Eldorado - IMAX", BigDecimal.ONE);
		List<Sessao> sessoes = Arrays.asList (new Sessao (horario, filme, sala));
		
		Sessao sessao = new Sessao (horario, filme, sala);
		
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao (sessoes);
		
		Assert.assertFalse(gerenciador.cabe(sessao));
	}

@Test
public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente () {
	Filme filme = new Filme ("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
	LocalTime horario = LocalTime.now();
	
	Sala sala = new Sala ("Eldorado - IMAX", BigDecimal.ONE);
	List<Sessao> sessoes = Arrays.asList (new Sessao (horario, filme, sala));
	
	Sessao sessao = new Sessao (horario.plusHours(1), filme, sala);
	GerenciadorDeSessao gerenciador = new GerenciadorDeSessao (sessoes);
	
	Assert.assertFalse(gerenciador.cabe(sessao));
}

@Test
public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente (){
	Filme filme = new Filme ("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
	LocalTime horario = LocalTime.now();
	Sala sala = new Sala ("Eldorado - IMAX", BigDecimal.ONE);
	
	List<Sessao> sessoesDaSala = Arrays.asList(new Sessao(horario, filme, sala));
	
	GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoesDaSala);
	Assert.assertFalse(gerenciador.cabe(new Sessao(horario.plusHours(1), filme, sala)));
}

@Test
public void garanteQueDevePermitirUmaInsercaoEntreDoisFilmes(){
	Sala sala = new Sala ("Eldorado - IMAX", BigDecimal.ONE);
	Filme filme1 = new Filme ("Rogue One", Duration.ofMinutes(90), "SCI-FI", BigDecimal.ONE);
	LocalTime dezHoras = LocalTime.parse("10:00:00");
	Sessao sessaoDasDez = new Sessao (dezHoras, filme1, sala);
	
	Filme filme2 = new Filme ("Rogue One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
	LocalTime dezoitoHoras = LocalTime.parse("18:00:00");
	Sessao sessaoDasDezoito = new Sessao (dezoitoHoras, filme2, sala);
	
	List<Sessao> sessoes = Arrays.asList(sessaoDasDez, sessaoDasDezoito);
	
	GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
	
	Assert.assertTrue(gerenciador.cabe(new Sessao(LocalTime.parse("13:00:00"), filme2, sala)));
}
}