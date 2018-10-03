package com.mx.xvhx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.xvhx.domain.User;
import com.mx.xvhx.domain.UserWithouthAuthorities;

public interface UserRepository extends JpaRepository<User, Long> {
	UserWithouthAuthorities findByUsername(String username);
}
