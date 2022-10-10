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

import com.lafisiotp.lafisiotp.model.Cita;
import com.lafisiotp.lafisiotp.service.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cita cita){
		return ResponseEntity.status(HttpStatus.CREATED).body(citaService.guardarCita(cita));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Cita> cita = citaService.consultarCitaPorId(id);
		if(!cita.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(cita);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cita citaDetalle, @PathVariable Long id){
		Optional<Cita> cita = citaService.consultarCitaPorId(id);
		if(!cita.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(citaDetalle, cita.get());
		cita.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(citaService.guardarCita(cita.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Cita> cita = citaService.consultarCitaPorId(id);
		if(!cita.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		citaService.eliminarCita(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Cita> readAll(){
		return citaService.consultarCita();
	}
}
