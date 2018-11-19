package com.vine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vine.model.AgendaMedico;
import com.vine.repository.AgendaRepository;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	public AgendaRepository dao;
	
	@Override
	public AgendaMedico fetchById(Long id) {
		return dao.getOne(id);
	}

	@Override
	public List<AgendaMedico> fetchAll() {
		return dao.findAll();
	}

	@Override
	public void delete(AgendaMedico i) throws Exception {
		dao.delete(i);
	}

	@Override
	public AgendaMedico create(AgendaMedico i) throws Exception {
		return dao.saveAndFlush(i);
	}

	@Override
	public AgendaMedico update(AgendaMedico i) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgendaMedico> fetchByMedicoId(Long medicoId) {
		return dao.fetchByMedicoId(medicoId);
	}

}
