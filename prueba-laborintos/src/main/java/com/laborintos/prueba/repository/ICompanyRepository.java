package com.laborintos.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laborintos.prueba.model.Company;

public interface ICompanyRepository extends JpaRepository<Company, Long> {

}
