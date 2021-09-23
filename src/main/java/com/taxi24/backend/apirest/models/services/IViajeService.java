package com.taxi24.backend.apirest.models.services;

import java.util.List;

import com.taxi24.backend.apirest.models.entity.Viaje;

public interface IViajeService {

	public List<Viaje> findAll();
	
	public List<Viaje> findByStatus(String string);
	
	public Viaje Save(Viaje viaje);
}
