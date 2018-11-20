package com.vine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vine.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}