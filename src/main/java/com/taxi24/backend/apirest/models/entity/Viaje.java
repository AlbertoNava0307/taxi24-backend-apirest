package com.taxi24.backend.apirest.models.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="viajes")
public class Viaje {
	
	public static final String STATUS_VIAJE_INICIADO = "I";
	public static final String STATUS_VIAJE_FINALIZADO = "I";
	public static final String STATUS_VIAJE_CANCEADO = "I";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(columnDefinition = "serial")
	private Long id;
	
	@Column(name="create_at")
	@CreationTimestamp
	private Timestamp createAt;
	
	private String status;
	
	private double costo;
	
	@Column(name="longitud_inicio")
	private double longitudInicio;
	
	@Column(name="latitud_inicio")
	private double latitudInicio;
	
	@Column(name="longitud_fin")
	private double longitudFin;
	
	@Column(name="latitud_fin")
	private double latitudFin;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="conductor_id")
	private Conductor conductor;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pasajero_id")
	private Pasajero pasajero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public double getLongitudFin() {
		return longitudFin;
	}

	public void setLongitudFin(double longitudFin) {
		this.longitudFin = longitudFin;
	}

	public double getLatitudFin() {
		return latitudFin;
	}

	public void setLatitudFin(double latitudFin) {
		this.latitudFin = latitudFin;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
}
