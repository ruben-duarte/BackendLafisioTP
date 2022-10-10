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

import com.lafisiotp.lafisiotp.model.HistoriaClinica;
import com.lafisiotp.lafisiotp.service.HistoriaClinicaService;

@RestController
@RequestMapping("/api/historiaclinica")
public class HistoriaClinicaController {
	
	@Autowired
	private HistoriaClinicaService historiaClinicaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody HistoriaClinica historiaClinica){
		return ResponseEntity.status(HttpStatus.CREATED).body(historiaClinicaService.guardarHistoriaClinica(historiaClinica));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<HistoriaClinica> historiaClinica = historiaClinicaService.consultarHistoriaClinicaPorId(id);
		if(!historiaClinica.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(historiaClinica);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody HistoriaClinica historiaClinicaDetalle, @PathVariable Long id){
		Optional<HistoriaClinica> historiaClinica = historiaClinicaService.consultarHistoriaClinicaPorId(id);
		if(!historiaClinica.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(historiaClinicaDetalle, historiaClinica.get());
		historiaClinica.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(historiaClinicaService.guardarHistoriaClinica(historiaClinica.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<HistoriaClinica> historiaClinica = historiaClinicaService.consultarHistoriaClinicaPorId(id);
		if(!historiaClinica.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		historiaClinicaService.eliminarHistoriaClinica(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<HistoriaClinica> readAll(){
		return historiaClinicaService.consultarHistoriaClinica();
	}
}
