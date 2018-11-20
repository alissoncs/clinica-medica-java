package com.vine.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vine.model.AgendaMedico;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaMedico, Long> {

	@Query("SELECT a FROM AgendaMedico a WHERE medico_id = :medicoId")
	public List<AgendaMedico> fetchByMedicoId(@Param("medicoId") Long medicoId);
	
	@Query("SELECT a FROM AgendaMedico a "
			+ "WHERE medico_id = :medicoId "
			+ "AND a.dataHora = :dataHora "
			+ "AND a.disponivel = true")
	public List<AgendaMedico> isDisponivelAgendaMedico(
			@Param("medicoId") Long medicoId,
			@Param("dataHora") LocalDateTime dataHora);
	
}
