package com.mx.xvhx.security.userdetails.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mx.xvhx.domain.Authority;
import com.mx.xvhx.domain.UserWithouthAuthorities;
import com.mx.xvhx.repository.AuthorityRepository;
import com.mx.xvhx.repository.UserRepository;
import com.mx.xvhx.security.userdetails.SecurityUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Primary
@Component
public class JpaSecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loading username: {}", username);

		UserWithouthAuthorities user = userRepository.findByUsername(username);
		log.info("user: {}", user);

		if (user == null) {
			log.error("username not found");
			throw new UsernameNotFoundException("username not found");
		}

		Set<Authority> authorities = authorityRepository.findByUsersUsername(username);
		log.info("findByUsersUsername authorities: {}", authorities);

		return new SecurityUser(user, authorities);
	}

}
