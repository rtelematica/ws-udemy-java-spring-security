package com.mx.xvhx.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.xvhx.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	@Query("SELECT a FROM Authority a INNER JOIN FETCH a.users users WHERE users.username = :username")
	Set<Authority> findAuthoritiesByUsername(@Param("username") String username);

	Set<Authority> findByUsersUsername(String username);
}
