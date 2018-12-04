package com.laborintos.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laborintos.prueba.model.Geolocation;

public interface IGeolocationRepository extends JpaRepository<Geolocation, Long> {

}
