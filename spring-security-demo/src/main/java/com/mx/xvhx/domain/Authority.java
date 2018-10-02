package com.mx.xvhx.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(exclude = { "users" })
@ToString(exclude = { "users" })
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = -7490555950279469454L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String authority;

	@ManyToMany(mappedBy = "authorities")
	private Set<User> users;
}
