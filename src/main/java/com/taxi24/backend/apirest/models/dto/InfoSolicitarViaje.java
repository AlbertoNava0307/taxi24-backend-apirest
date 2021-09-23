package com.taxi24.backend.apirest.models.dto;

public class InfoSolicitarViaje {

	private double costo;
	private double longitudInicio;
	private double latitudInicio;
	private Long conductor_id;
	private Long pasajero_id;
	
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getLongitudInicio() {
		return longitudInicio;
	}
	public void setLongitudInicio(double longitudInicio) {
		this.longitudInicio = longitudInicio;
	}
	public double getLatitudInicio() {
		return latitudInicio;
	}
	public void setLatitudInicio(double latitudInicio) {
		this.latitudInicio = latitudInicio;
	}
	public Long getConductor_id() {
		return conductor_id;
	}
	public void setConductor_id(Long conductor_id) {
		this.conductor_id = conductor_id;
	}
	public Long getPasajero_id() {
		return pasajero_id;
	}
	public void setPasajero_id(Long pasajero_id) {
		this.pasajero_id = pasajero_id;
	}
}
