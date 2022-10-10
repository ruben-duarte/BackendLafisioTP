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

import com.lafisiotp.lafisiotp.model.Calendario;
import com.lafisiotp.lafisiotp.service.CalendarioService;

@RestController
@RequestMapping("/api/calendarios")
public class CalendarioController {
	
	@Autowired
	private CalendarioService calendarioService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Calendario calendario){
		return ResponseEntity.status(HttpStatus.CREATED).body(calendarioService.guardarCalendario(calendario));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Calendario> calendario = calendarioService.consultarCalendarioPorId(id);
		if(!calendario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(calendario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Calendario calendarioDetalle, @PathVariable Long id){
		Optional<Calendario> calendario = calendarioService.consultarCalendarioPorId(id);
		if(!calendario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(calendarioDetalle, calendario.get());
		calendario.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(calendarioService.guardarCalendario(calendario.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Calendario> calendario = calendarioService.consultarCalendarioPorId(id);
		if(!calendario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		calendarioService.eliminarCalendario(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Calendario> readAll(){
		return calendarioService.consultarCalendario();
	}
}
