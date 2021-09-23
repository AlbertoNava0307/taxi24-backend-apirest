package com.taxi24.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxi24.backend.apirest.models.dao.IConductorDao;
import com.taxi24.backend.apirest.models.entity.Conductor;

@Service
public class ConductorServiceImpl implements IConductorService {
	
	@Autowired
	private IConductorDao conductorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Conductor> findAll() {
		return (List<Conductor>) conductorDao.findAll();
	}

	@Override
	public List<Conductor> findByDisponible() {
		return conductorDao.findByDisponible(true);
	}
	
	@Override
	public List<Conductor> findByDisponibleAndLocation() {
		return conductorDao.findByDisponible(true);
	}

	@Override
	public Optional<Conductor> findById(Long id) {
		return conductorDao.findById(id);
	}

}
