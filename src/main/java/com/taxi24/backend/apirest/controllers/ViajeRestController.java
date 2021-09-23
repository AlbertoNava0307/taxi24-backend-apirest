package com.taxi24.backend.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi24.backend.apirest.models.dto.InfoSolicitarViaje;
import com.taxi24.backend.apirest.models.entity.Conductor;
import com.taxi24.backend.apirest.models.entity.Pasajero;
import com.taxi24.backend.apirest.models.entity.Viaje;
import com.taxi24.backend.apirest.models.services.IConductorService;
import com.taxi24.backend.apirest.models.services.IPasajeroService;
import com.taxi24.backend.apirest.models.services.IViajeService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/taxi24")
public class ViajeRestController {
	
	@Autowired
	private IViajeService viajeService;
	
	@Autowired
	private IConductorService conductorService;
	
	@Autowired
	private IPasajeroService pasajeroService;

	//obtiene una lista de todos los viajes activos
	@GetMapping("/viajes")
	public List<Viaje> getViajesActivos(){
		return viajeService.findByStatus(Viaje.STATUS_VIAJE_INICIADO);
	}
	
	//crea una neva solicitud de "Viaje" asignando un conductor al viaje
	@PostMapping("/viajes")
	public ResponseEntity<?> create(@RequestBody InfoSolicitarViaje infoSolicitarViaje){
		Viaje viaje = new Viaje();
		
		viaje.setCosto(infoSolicitarViaje.getCosto());
		viaje.setLatitudInicio(infoSolicitarViaje.getLatitudInicio());
		viaje.setLongitudInicio(infoSolicitarViaje.getLongitudInicio());
		viaje.setStatus(Viaje.STATUS_VIAJE_INICIADO);
		
		Optional<Conductor> conductor = conductorService.findById((long) infoSolicitarViaje.getConductor_id());
		viaje.setConductor(conductor.get());
		Optional<Pasajero> pasajero = pasajeroService.findById((long) infoSolicitarViaje.getPasajero_id());
		viaje.setPasajero(pasajero.get());
		Viaje response = viajeService.Save(viaje);
		return new ResponseEntity<Viaje>(response, HttpStatus.OK);
	}
}
