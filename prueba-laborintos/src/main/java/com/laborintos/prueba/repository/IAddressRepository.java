package com.laborintos.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laborintos.prueba.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long>  {

}
