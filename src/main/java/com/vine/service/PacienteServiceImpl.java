package com.vine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vine.model.Paciente;
import com.vine.repository.MedicoRepository;
import com.vine.repository.PacienteRespository;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRespository dao;
	
	@Override
	public Paciente fetchById(Long id) {
		return dao.getOne(id);
	}

	@Override
	public List<Paciente> fetchAll() {
		return dao.findAll(); 
	}

	@Override
	public void delete(Paciente i) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente create(Paciente i) throws Exception {
		return dao.saveAndFlush(i);
	}

	@Override
	public Paciente update(Paciente i) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
