package com.taxi24.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taxi24.backend.apirest.models.entity.Viaje;

public interface IViajeDao extends CrudRepository<Viaje, Long> {

	public List<Viaje> findByStatus(String status);
}
