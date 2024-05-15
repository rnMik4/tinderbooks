package br.com.rnrafa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rnrafa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}
