package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafisiotp.lafisiotp.model.Usuario;
import com.lafisiotp.lafisiotp.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repositorio;

	@Override
	public List<Usuario> consultarUsuario() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Usuario> consultarUsuarioPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		repositorio.deleteById(id);
	}

}
