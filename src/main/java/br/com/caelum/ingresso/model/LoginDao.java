package br.com.caelum.ingresso.model;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

public class LoginDao {
	
	@Repository
	public class LoginDao implements implemnets UserDetailsService {
		
		@PersistenceContex
		private EntityManager manger;
		
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			try {
				return manager
						.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
						.setParameter("email", email)
						.getSingleResult();
			} cath (NoResultException e) {
				throw new UsernameNotFoundException("email" + email + "Não encontrado!!");
			}
		}
	}


