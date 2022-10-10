package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import com.lafisiotp.lafisiotp.model.Cita;

public interface CitaService {
	public List<Cita> consultarCita();
	public Optional<Cita> consultarCitaPorId(Long id);
	public Cita guardarCita(Cita cita);
	public void eliminarCita(Long id);
}
