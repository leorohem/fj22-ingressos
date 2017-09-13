package br.com.caelum.ingresso.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.caelum.ingresso.model.Permissao;

public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String email;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Permissao> permissoes = new HashSet<>();
	
	/**
	 * @deprecated hibernate only
	 */
	
	public Usuario() {
	}
	
	public Usuario(String email, String password, Set<Permissao> permissoes) {	
		this.email = email;
		this.password = password;
		this.permissoes = permissoes;
	}	

}
