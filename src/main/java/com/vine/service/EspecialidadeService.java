package com.vine.service;

import com.vine.model.Especialidade;

public interface EspecialidadeService extends BaseService<Especialidade> {
	public boolean exists(Long id) throws Exception;
}
