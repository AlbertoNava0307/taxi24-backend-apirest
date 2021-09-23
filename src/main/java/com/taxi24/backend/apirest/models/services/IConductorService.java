package com.taxi24.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import com.taxi24.backend.apirest.models.entity.Conductor;

public interface IConductorService {
	
	public Optional<Conductor> findById(Long id);

	public List<Conductor> findAll();
	
	public List<Conductor> findByDisponible();

	public List<Conductor> findByDisponibleAndLocation();
}
