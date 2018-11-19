package com.vine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vine.model.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long>{

}
