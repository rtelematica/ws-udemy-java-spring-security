package com.mx.xvhx.security.userdetails;

import org.springframework.security.core.userdetails.UserDetails;

import com.mx.xvhx.domain.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 2574995909553761349L;

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
