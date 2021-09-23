package com.taxi24.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi24.backend.apirest.models.dao.IViajeDao;
import com.taxi24.backend.apirest.models.entity.Viaje;


@Service
public class ViajeServiceImpl implements IViajeService {

	@Autowired
	private IViajeDao viajeDao;

	@Override
	public List<Viaje> findAll() {
		return (List<Viaje>) viajeDao.findAll();
	}

	@Override
	public Viaje Save(Viaje viaje) {
		return viajeDao.save(viaje);
	}

	@Override
	public List<Viaje> findByStatus(String status) {
		return viajeDao.findByStatus(status);
	}

}
