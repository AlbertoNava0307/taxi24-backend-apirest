package com.taxi24.backend.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.taxi24.backend.apirest.location.LocationGeoLite2;
import com.taxi24.backend.apirest.models.entity.Conductor;
import com.taxi24.backend.apirest.models.entity.Viaje;

@SpringBootApplication
public class Taxi24BackendApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Taxi24BackendApirestApplication.class, args);
	}
	
	/*@Bean
	public void crearDatos() {
		Viaje viaje = new Viaje();
		viaje.setCosto(200);
		viaje.setLatitudInicio(0);
		viaje.setLongitudInicio(0);
		viaje.setLatitudFin(0);
		viaje.setLongitudFin(0);
		viaje.setStatus(null);
		
		Conductor conductor = new Conductor();
		viaje.setConductor(conductor);
	}*/
	
	/*@Bean
	public void prueba() {
		LocationGeoLite2.getLocation();
	}*/

}
