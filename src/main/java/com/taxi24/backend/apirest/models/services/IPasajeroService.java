package com.taxi24.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import com.taxi24.backend.apirest.models.entity.Pasajero;

public interface IPasajeroService {

	public Optional<Pasajero> findById(Long id);
	
	public List<Pasajero> findAll();
}
