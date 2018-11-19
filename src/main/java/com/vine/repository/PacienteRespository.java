package com.vine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vine.model.Paciente;

@Repository
public interface PacienteRespository extends JpaRepository<Paciente, Long>{

}
