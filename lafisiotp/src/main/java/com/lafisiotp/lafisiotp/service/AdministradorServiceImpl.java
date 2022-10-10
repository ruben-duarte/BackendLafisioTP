package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafisiotp.lafisiotp.model.Administrador;
import com.lafisiotp.lafisiotp.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {
	
	@Autowired
	private AdministradorRepository repositorio;

	@Override
	@Transactional
	public List<Administrador> consultarAdministradores() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public Optional<Administrador> consultarAdministradorPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public Administrador guardarAdministrador(Administrador administrador) {
		return repositorio.save(administrador);
	}

	@Override
	@Transactional
	public void eliminarAdministrador(Long id) {
		repositorio.deleteById(id);

	}

}
