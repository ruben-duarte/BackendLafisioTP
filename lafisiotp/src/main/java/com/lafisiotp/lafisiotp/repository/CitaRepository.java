package com.lafisiotp.lafisiotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lafisiotp.lafisiotp.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{

}
