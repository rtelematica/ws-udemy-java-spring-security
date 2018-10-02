package com.mx.xvhx.security.userdetails.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mx.xvhx.domain.Authority;
import com.mx.xvhx.domain.User;
import com.mx.xvhx.repository.AuthorityRepository;
import com.mx.xvhx.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Primary
@Component
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loading username: {}", username);

		User user = userRepository.findByUsername(username);
		log.info("user: {}", user);

		Set<Authority> authorities = authorityRepository.findByUsersUsername(username);
		log.info("findByUsersUsername authorities: {}", authorities);

		if (user == null) {
			log.error("username not found");
			throw new UsernameNotFoundException("username not found");
		}

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				AuthorityUtils.commaSeparatedStringToAuthorityList("USER,ADMIN"));
	}

}
