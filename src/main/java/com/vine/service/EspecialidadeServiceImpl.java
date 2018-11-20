package com.vine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vine.model.Especialidade;
import com.vine.repository.EspecialidadeRepository;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	public EspecialidadeRepository dao;
	
	@Override
	public Especialidade fetchById(Long id) {
		return dao.getOne(id);
	}

	@Override
	public List<Especialidade> fetchAll() {
		return dao.findAll();
	}

	@Override
	public void delete(Especialidade i) throws Exception {
		dao.delete(i);
	}

	@Override
	public Especialidade create(Especialidade i) throws Exception {
		return dao.save(i);
	}

	@Override
	public Especialidade update(Especialidade i) throws Exception {
		return dao.save(i);
	}

	@Override
	public boolean exists(Long id) throws Exception {
		return dao.existsById(id);
	}

}
