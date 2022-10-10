package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import com.lafisiotp.lafisiotp.model.Calendario;

public interface CalendarioService {
	public List<Calendario> consultarCalendario();
	public Optional<Calendario> consultarCalendarioPorId(Long id);
	public Calendario guardarCalendario(Calendario calendario);
	public void eliminarCalendario(Long id);
}
