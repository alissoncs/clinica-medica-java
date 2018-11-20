package com.vine.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vine.exception.BusinessValidationException;
import com.vine.model.AgendaMedico;
import com.vine.model.Consulta;
import com.vine.repository.AgendaRepository;
import com.vine.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	
	@Autowired
	private ConsultaRepository dao;
	
	@Autowired 
	private AgendaRepository agendaDao;

	@Override
	public Consulta fetchById(Long id) {
		return dao.getOne(id);
	}

	@Override
	public List<Consulta> fetchAll() {
		return dao.findAll();
	}

	@Override
	public void delete(Consulta consulta) throws Exception {
		consulta.setStatus(Consulta.Status.CANCELADO_PELO_USUARIO);
		this.update(consulta);
	}

	@Override
	public Consulta create(Consulta consulta) throws Exception {
		return dao.save(consulta);
	}
	
	@Transactional
	public Consulta createConsultaWithValidations(Consulta consulta) throws BusinessValidationException, Exception {
		if (consulta.getMedico() == null) {
			throw new BusinessValidationException("Médico é obrigatório");
		}
		
		if (consulta.getPaciente() == null) {
			throw new BusinessValidationException("Paciente é obrigatório");
		}
		
		if (consulta.getAtendente() == null) {
			throw new BusinessValidationException("Atendente é obrigatório");
		}
		
		// verifica a agenda do médico esta disponível
		LocalDateTime dataHora = consulta.getDataHora();
		
		if (dataHora == null) {
			throw new BusinessValidationException("Data e hora da consulta é obrigatório");
		}
		
		List<AgendaMedico> agendaDisponivel = agendaDao.isDisponivelAgendaMedico(
				consulta.getMedico().getId(),
				dataHora);
		
		if (agendaDisponivel.isEmpty()) {
			throw new BusinessValidationException("Médico " + consulta.getMedico().getNome() + " não possui este horário/data na agenda");
		}
		
		// atualiza item da agenda
		AgendaMedico agenda = agendaDisponivel.get(0);
		consulta.setStatus(Consulta.Status.A_CONFIRMAR);
		agenda.setDisponivel(false);
		
		agendaDao.saveAndFlush(agenda);
		
		return create(consulta);
	}

	@Override
	public Consulta update(Consulta consulta) throws Exception {
		return dao.saveAndFlush(consulta);
	}

	@Override
	public List<Consulta> fetchByMedicoId(Long medicoId) throws Exception {
		return dao.fetchByMedicoId(medicoId);
	}

	@Override
	public List<Consulta> fetchByPacienteId(Long pacienteId) throws Exception {
		return dao.fetchByPacienteId(pacienteId);
	}
	
}
