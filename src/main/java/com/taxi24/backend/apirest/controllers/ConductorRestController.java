package com.taxi24.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi24.backend.apirest.location.LocationGeoLite2;
import com.taxi24.backend.apirest.models.entity.Conductor;
import com.taxi24.backend.apirest.models.entity.Coordenada;
import com.taxi24.backend.apirest.models.services.IConductorService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/taxi24")
public class ConductorRestController {

	@Autowired
	private IConductorService conductorService;
	
	//Obtiene lista de todos los conductores
	@GetMapping("/conductores")
	public List<Conductor> getConductores(){
		return conductorService.findAll();
	}
	
	//Obtiene lista de todos los disponibles
	@GetMapping("/conductores-disponibles")
	public List<Conductor> getConductoresDisponibles(){
		return conductorService.findByDisponible();
	}
	
	//Obtiene lista de todos los disponibles en un rango de 3km
	@GetMapping("/conductores-disponibles-location")
	public List<Conductor> getConductoresDisponiblesLocation(@RequestBody Coordenada coordenadas){
		
		List<Conductor> conductoresDisponibles = conductorService.findByDisponible();
		ArrayList<Conductor> conductoresDisponiblesLocation =  new ArrayList<Conductor>();
		for (Conductor conductor : conductoresDisponibles) {
			double distancia = LocationGeoLite2.distanciaCoord(coordenadas.getLatitud(), coordenadas.getLongitud(), conductor.getLatitud(), conductor.getLongitud());
			System.out.println(distancia);
			if(distancia <= 3) {
				conductoresDisponiblesLocation.add(conductor);
			}
		}
		
		return conductoresDisponiblesLocation;
	}
	
	//obtiene un conductor especifico por ID
	@GetMapping("/conductores/{id}")
	public ResponseEntity<?> getConductorById(@PathVariable Long id){
		
		Optional<Conductor> conductor = null;
		Map <String, Object> response = new HashMap<>();
		
		conductor = conductorService.findById(id);
		if(conductor.isEmpty()) {
			response.put("mensaje", "El conductor con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map <String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Conductor>(conductor.get(), HttpStatus.OK);
	}
}
