package com.sprinboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder( ) {
		return new BCryptPasswordEncoder();
		
		
	}


	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/img/**","/home","/informacion","/assets/**","/fonts/**").permitAll()
		.antMatchers("/new").hasAnyRole("ADMIN")
		.antMatchers("/listar").hasAnyRole("ADMIN")
		.antMatchers("/elminar/**").hasAnyRole("ADMIN")
		.antMatchers("/listarAsistencias").hasAnyRole("ADMIN")
		.antMatchers("/form/**").hasAnyRole("ADMIN")
		.antMatchers("/eliminarAsistencia/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/home", true)
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/home")
		.permitAll();
		

	}
	




	@Autowired
	public void ConfigurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("8uBQiyecwXf6KIX1C3").roles("ADMIN" , "USER"));
		
	}
	
	
	

}
