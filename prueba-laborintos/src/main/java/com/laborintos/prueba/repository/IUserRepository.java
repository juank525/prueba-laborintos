package com.laborintos.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laborintos.prueba.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
}
