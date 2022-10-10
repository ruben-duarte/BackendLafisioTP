package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import com.lafisiotp.lafisiotp.model.HistoriaClinica;

public interface HistoriaClinicaService {
	public List<HistoriaClinica> consultarHistoriaClinica();
	public Optional<HistoriaClinica> consultarHistoriaClinicaPorId(Long id);
	public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica);
	public void eliminarHistoriaClinica(Long id);
}
