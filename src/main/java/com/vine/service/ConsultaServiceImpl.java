package com.vine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vine.model.Consulta;
import com.vine.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	
	@Autowired
	private ConsultaRepository dao;

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

	@Override
	public Consulta update(Consulta consulta) throws Exception {
		return dao.saveAndFlush(consulta);
	}
	
}
