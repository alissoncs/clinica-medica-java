package com.vine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vine.model.AgendaMedico;
import com.vine.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
	@Query("SELECT c, p.nome FROM Consulta c, Medico m, Paciente p")
	public List<Consulta> fetchWithMedico();
	
	@Query("SELECT c FROM Consulta c WHERE medico_id = :medicoId")
	public List<Consulta> fetchByMedicoId(@Param("medicoId") Long medicoId);
	
	@Query("SELECT c FROM Consulta c WHERE paciente_id = :pacienteId")
	public List<Consulta> fetchByPacienteId(@Param("pacienteId") Long pacienteId);
}