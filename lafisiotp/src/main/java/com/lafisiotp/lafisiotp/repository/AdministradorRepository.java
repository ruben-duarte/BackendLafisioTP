package com.lafisiotp.lafisiotp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lafisiotp.lafisiotp.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>  {

}
