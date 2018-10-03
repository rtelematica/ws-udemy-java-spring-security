package com.mx.xvhx.security.userdetails;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.mx.xvhx.domain.Authority;
import com.mx.xvhx.domain.User;
import com.mx.xvhx.domain.UserWithouthAuthorities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 2574995909553761349L;

	public SecurityUser(UserWithouthAuthorities user, Set<Authority> authorities) {
		this.setId(user.getId());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(authorities);
	}

	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

}
