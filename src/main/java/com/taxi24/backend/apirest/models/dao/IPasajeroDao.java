package com.taxi24.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.taxi24.backend.apirest.models.entity.Pasajero;

public interface IPasajeroDao extends CrudRepository<Pasajero, Long> {

}
