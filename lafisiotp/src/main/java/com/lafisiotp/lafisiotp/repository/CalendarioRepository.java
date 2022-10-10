package com.lafisiotp.lafisiotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lafisiotp.lafisiotp.model.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long>{

}
