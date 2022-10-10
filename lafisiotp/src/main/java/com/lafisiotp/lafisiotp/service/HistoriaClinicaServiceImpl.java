package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafisiotp.lafisiotp.model.HistoriaClinica;
import com.lafisiotp.lafisiotp.repository.HistoriaClinicaRepository;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {
	
	@Autowired
	private HistoriaClinicaRepository repositorio;

	@Override
	public List<HistoriaClinica> consultarHistoriaClinica() {
		return repositorio.findAll();
	}

	@Override
	public Optional<HistoriaClinica> consultarHistoriaClinicaPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
		return repositorio.save(historiaClinica);
	}

	@Override
	public void eliminarHistoriaClinica(Long id) {
		repositorio.deleteById(id);

	}

}
