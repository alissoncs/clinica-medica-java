package com.vine.service;

import com.vine.dto.MedicoDTO;
import com.vine.model.Medico;

public interface MedicoService extends BaseService<Medico> {
	public Medico createMedicoFromDto(MedicoDTO medicoDto);
}
