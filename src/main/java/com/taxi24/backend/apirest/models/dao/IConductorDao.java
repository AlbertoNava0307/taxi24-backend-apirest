package com.taxi24.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taxi24.backend.apirest.models.entity.Conductor;

public interface IConductorDao extends CrudRepository<Conductor, Long> {

	public List<Conductor> findByDisponible(Boolean disponible);
}
