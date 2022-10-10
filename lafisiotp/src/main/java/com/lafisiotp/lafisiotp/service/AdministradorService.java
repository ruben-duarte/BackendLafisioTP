package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import com.lafisiotp.lafisiotp.model.Administrador;

public interface AdministradorService {
	public List<Administrador> consultarAdministradores();
	public Optional<Administrador> consultarAdministradorPorId(Long id);
	public Administrador guardarAdministrador(Administrador administrador);
	public void eliminarAdministrador(Long id);
}
