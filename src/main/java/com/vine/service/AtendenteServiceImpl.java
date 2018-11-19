package com.vine.service;

import java.util.List;

import com.vine.model.Atendente;
import com.vine.repository.AtendenteRepository;

public class AtendenteServiceImpl implements AtendenteService{
	
	public AtendenteRepository dao;

	@Override
	public Atendente fetchById(Long id) {
		return dao.getOne(id);
	}

	@Override
	public List<Atendente> fetchAll() {
		return dao.findAll();
	}

	@Override
	public void delete(Atendente i) throws Exception {
		dao.delete(i);
	}

	@Override
	public Atendente create(Atendente i) throws Exception {
		return dao.saveAndFlush(i);
	}

	@Override
	public Atendente update(Atendente i) throws Exception {
		return dao.saveAndFlush(i);
	}
}
