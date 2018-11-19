package com.vine.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vine.model.Medico;
import com.vine.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository dao;
	
	@Override
	public Medico fetchById(Long id) {
		Medico medico = dao.getOne(id);
		if(!Hibernate.isInitialized(medico.getAgendas()))
			Hibernate.initialize(medico.getAgendas());
	
		medico.getAgendas();
		return medico;
	}

	@Override
	public List<Medico> fetchAll() {
		
		
		return dao.findAll(); 
	}

	@Override
	public void delete(Medico i) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medico create(Medico i) throws Exception {
		return dao.saveAndFlush(i);
	}

	@Override
	public Medico update(Medico i) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
