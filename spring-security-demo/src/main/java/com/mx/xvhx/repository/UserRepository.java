package com.mx.xvhx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.xvhx.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
