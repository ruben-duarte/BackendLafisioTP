package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafisiotp.lafisiotp.model.Cita;
import com.lafisiotp.lafisiotp.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService {
	
	@Autowired
	private CitaRepository repositorio;

	@Override
	@Transactional
	public List<Cita> consultarCita() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<Cita> consultarCitaPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public Cita guardarCita(Cita cita) {
		return repositorio.save(cita);
	}

	@Override
	@Transactional
	public void eliminarCita(Long id) {
		repositorio.deleteById(id);

	}

}
