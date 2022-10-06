package com.api.spring.security.login.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.spring.security.login.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{
	 Optional<Pessoa>findByUsername(String name);
	
	
}
