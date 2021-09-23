package com.taxi24.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi24.backend.apirest.models.dao.IPasajeroDao;
import com.taxi24.backend.apirest.models.entity.Pasajero;

@Service
public class PasajeroServiceImpl implements IPasajeroService {
	
	@Autowired
	private IPasajeroDao pasajeroDao;

	@Override
	public Optional<Pasajero> findById(Long id) {
		return pasajeroDao.findById(id);
	}

	@Override
	public List<Pasajero> findAll() {
		return (List<Pasajero>) pasajeroDao.findAll();
	}

}
