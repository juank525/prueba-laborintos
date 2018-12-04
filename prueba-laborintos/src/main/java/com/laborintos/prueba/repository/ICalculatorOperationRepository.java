package com.laborintos.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laborintos.prueba.model.CalculatorOperation;

public interface ICalculatorOperationRepository  extends JpaRepository<CalculatorOperation, Long> {

}
