package com.vine.service;

import java.util.List;

import com.vine.model.AgendaMedico;

public interface AgendaService extends BaseService<AgendaMedico>{

	public List<AgendaMedico> fetchByMedicoId(Long medicoId);
}
