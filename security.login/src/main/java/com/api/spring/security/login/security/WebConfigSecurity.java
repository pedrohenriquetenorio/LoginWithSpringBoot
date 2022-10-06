//MAPEAMENDO DE URL, endereçom autoriza ou bloqueia acesso a URL
//Interceptador de requisições

package com.api.spring.security.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration 
//@EnableWebSecurity // serve para desligar todas as configurações defalt do spring e leva em consideração as configurações personalizadas 
public class WebConfigSecurity{
	
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.httpBasic() // chama o BasicAuthinticationFilter e processa qualquer solicitação que tenha um cabeçalho de solicitação HTTP
		.and() // serve para unir as configurações
		.authorizeHttpRequests()
		.anyRequest().authenticated()
		.and()
		.csrf().disable();
		
		return http.build();	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		
		return new BCryptPasswordEncoder();
		
	}
	
	
}
