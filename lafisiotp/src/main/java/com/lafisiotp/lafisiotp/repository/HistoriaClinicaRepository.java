package com.lafisiotp.lafisiotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lafisiotp.lafisiotp.model.HistoriaClinica;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long>{

}
