package com.lafisiotp.lafisiotp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lafisiotp.lafisiotp.model.Usuario;
import com.lafisiotp.lafisiotp.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardarUsuario(usuario));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Usuario> usuario = usuarioService.consultarUsuarioPorId(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioDetalle, @PathVariable Long id){
		Optional<Usuario> usuario = usuarioService.consultarUsuarioPorId(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(usuarioDetalle, usuario.get());
		usuario.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardarUsuario(usuario.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Usuario> usuario = usuarioService.consultarUsuarioPorId(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		usuarioService.eliminarUsuario(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Usuario> readAll(){
		return usuarioService.consultarUsuario();
	}
}
