package com.vine.service;
import java.util.List;

import com.vine.exception.BusinessValidationException;
import com.vine.model.Consulta;

public interface ConsultaService extends BaseService<Consulta> {
	public Consulta createConsultaWithValidations(Consulta consulta)
			throws BusinessValidationException, Exception;
	
	public List<Consulta> fetchByMedicoId(Long medicoId) throws Exception;
	public List<Consulta> fetchByPacienteId(Long medicoId) throws Exception;
}