package com.api.spring.security.login.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.spring.security.login.entity.Pessoa;
import com.api.spring.security.login.repository.PessoaRepository;



@Service 
public class UserDetailsServiceImpl implements UserDetailsService {
	
	final PessoaRepository pessoaRepository;
	
	public UserDetailsServiceImpl(PessoaRepository pessoaRepository) {
	
		this.pessoaRepository = pessoaRepository;
	} 
	
	@Override // busca na base de dados o usuario responsavel por esse username
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Pessoa pessoa = pessoaRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado" + username));
		return pessoa;
	}
	
	
		
}
