package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

public class Permissao {
	
	@Entity
	public class Permissao implements GrantedAuthority {
		@Id
		private String nome;
		
		public Permissao(String nome) {
		}
		
		/**
		 * @deprecated hibernate only
		 */
		
		public Permissao() {
		}
		
		public String getNome() {
			return nome;
		}
		
		@Override
		public String getAuthority() {
			return nome;
		}
	}
	private String nome;
	
	public Permissao(String nome) {
		this.nome = nome;
	}
	
	public Permissao() {
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getNome() {
		this.nome = nome;
	}
	
}
