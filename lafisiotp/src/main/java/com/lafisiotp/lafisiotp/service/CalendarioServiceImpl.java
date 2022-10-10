package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafisiotp.lafisiotp.model.Calendario;
import com.lafisiotp.lafisiotp.repository.CalendarioRepository;

@Service
public class CalendarioServiceImpl implements CalendarioService {
	
	@Autowired
	private CalendarioRepository repositorio;

	@Override
	@Transactional
	public List<Calendario> consultarCalendario() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<Calendario> consultarCalendarioPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public Calendario guardarCalendario(Calendario calendario) {
		return repositorio.save(calendario);
	}

	@Override
	@Transactional
	public void eliminarCalendario(Long id) {
		repositorio.deleteById(id);

	}

}
