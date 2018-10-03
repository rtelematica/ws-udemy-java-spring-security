package com.mx.xvhx.domain;

import java.util.Set;

public interface UserWithAuthorities extends UserWithouthAuthorities {

	public Set<Authority> getAuthorities();

	public void setAuthorities(Set<Authority> authorities);
}
