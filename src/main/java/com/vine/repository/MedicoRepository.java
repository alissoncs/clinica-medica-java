package com.vine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vine.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
