package com.lafisiotp.lafisiotp.service;

import java.util.List;
import java.util.Optional;

import com.lafisiotp.lafisiotp.model.Usuario;

public interface UsuarioService {
	public List<Usuario> consultarUsuario();
	public Optional<Usuario> consultarUsuarioPorId(Long id);
	public Usuario guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Long id);
}
