package com.mx.xvhx.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	// Authentication configuration
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//User.withDefaultPasswordEncoder().username(username)

		/*auth
			.inMemoryAuthentication()
				.withUser("ivan")
				.password("123")
				.roles("USER", "ADMIN")
				.and()
			.passwordEncoder(passwordEncoder);*/

		/*auth
			.inMemoryAuthentication()
				.withUser(User.builder()
						.username("ivan")
						.password("123")
						.roles("USER", "ADMIN")
						.build())
				.withUser(User.builder()
						.username("ilse")
						.password("456")
						.roles("USER", "ADMIN")
						.build())
				.passwordEncoder(passwordEncoder);*/

		//Spring Security deprecates NoOpPasswordEncoder, useful just for tests.

		// see this for password encoder issue in Spring Security 5.
		// https://stackoverflow.com/questions/46999940/spring-boot-passwordencoder-error
		// user .password("{noop}123") to skip password encoder
		
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
		

	}

	// Authroization configuration
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				//.anyRequest().hasAnyRole("USER")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.failureUrl("/login?error")
				.permitAll();
	}

}
