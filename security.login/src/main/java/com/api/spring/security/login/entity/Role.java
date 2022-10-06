package com.api.spring.security.login.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.api.spring.security.login.enums.RoleName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//PARA A ROLE 

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")

//GRANTED AUTHORITY -> 


public class Role implements GrantedAuthority, Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Enumerated(EnumType.STRING) // salva no banco um ENUM do tipo String
	@Column(name = "role_name", nullable = false, unique = true)
	private RoleName roleName; // tipo ENUM
	@Override
	
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.roleName.toString(); // TRANSFORMA O RETORNO DO METODO DE ENUM PARA STRING 
	}

	
}
