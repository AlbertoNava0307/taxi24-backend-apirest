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
import com.taxi24.backend.apirest.models.entity.Pasajero;
import com.taxi24.backend.apirest.models.services.IConductorService;
import com.taxi24.backend.apirest.models.services.IPasajeroService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/taxi24")
public class PasajeroRestController {

	@Autowired
	IPasajeroService pasajeroService;
	
	@Autowired
	private IConductorService conductorService;
	
	//obtiene una lista de todos los pasajeros
	@GetMapping("/pasajeros")
	public List<Pasajero> getPasajeros(){
		return pasajeroService.findAll();
	}
	
	//obtiene un pasajero especifico por ID
	@GetMapping("/pasajeros/{id}")
	public ResponseEntity<?> getPasajeroById(@PathVariable Long id){
		Optional<Pasajero> pasajero = null;
		Map <String, Object> response = new HashMap<>();
		
		pasajero = pasajeroService.findById(id);
		if(pasajero.isEmpty()) {
			response.put("mensaje", "El pasajero con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map <String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Pasajero>(pasajero.get(), HttpStatus.OK);
	}
	
	//obtiene una lista de los 3 conductores más cercanos al punto de partida
	@GetMapping("/conductores-cercanos")
	public List<Conductor> getConductoresCercanos(@RequestBody Coordenada coordenadas){
		List<Conductor> conductoresDisponibles = conductorService.findByDisponible();
		for(int i=0;i<(conductoresDisponibles.size()-1);i++) {
			for(int j=i+1;j>0;j--){
				double distanciaA = LocationGeoLite2.distanciaCoord(coordenadas.getLatitud(), coordenadas.getLongitud(), conductoresDisponibles.get(j).getLatitud(), conductoresDisponibles.get(j).getLongitud());
				double distanciaB = LocationGeoLite2.distanciaCoord(coordenadas.getLatitud(), coordenadas.getLongitud(), conductoresDisponibles.get(j-1).getLatitud(), conductoresDisponibles.get(j-1).getLongitud());
				if(distanciaA<distanciaB) {
					Conductor ConductorTemp = conductoresDisponibles.get(j-1);
					conductoresDisponibles.set(j-1, conductoresDisponibles.get(j));
					conductoresDisponibles.set(j, ConductorTemp);
				}
            }
		}
		ArrayList<Conductor> conductoresDisponiblesLocation =  new ArrayList<Conductor>();
		conductoresDisponiblesLocation.add(conductoresDisponibles.get(0));
		conductoresDisponiblesLocation.add(conductoresDisponibles.get(1));
		conductoresDisponiblesLocation.add(conductoresDisponibles.get(2));
		
		return conductoresDisponiblesLocation;
	}
}
