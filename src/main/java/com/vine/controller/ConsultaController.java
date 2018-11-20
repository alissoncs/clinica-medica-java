package com.vine.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vine.dto.ConsultaDTO;
import com.vine.model.Atendente;
import com.vine.model.Consulta;
import com.vine.model.Medico;
import com.vine.model.Paciente;
import com.vine.service.AtendenteService;
import com.vine.service.ConsultaService;
import com.vine.service.MedicoService;
import com.vine.service.PacienteService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private AtendenteService atendenteService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<ConsultaDTO>> getConsultas() {
		
		ModelMapper mapper = new ModelMapper();
		List<Consulta> consultas = consultaService.fetchAll();
		List<ConsultaDTO> dtoList = new ArrayList<ConsultaDTO>();
		for(Consulta c: consultas) {
			ConsultaDTO dto = mapper.map(c, ConsultaDTO.class);
			dtoList.add(dto);
		}
		
		return new ResponseEntity<List<ConsultaDTO>>(dtoList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> createConsulta(@RequestBody ConsultaDTO data) throws Exception {
		ModelMapper mapper = new ModelMapper();
		Consulta consulta = mapper.map(data, Consulta.class);
		
		// carrega medico ID
		if (data.getMedicoId() != null) {
			Medico medico = medicoService.fetchById(data.getMedicoId());
			consulta.setMedico(medico);
		}
		
		if (data.getAtendenteId() != null) {
			// carrega atendente ID
			Atendente atendente = atendenteService.fetchById(data.getAtendenteId());
			consulta.setAtendente(atendente);
		}
		
		if (data.getPacienteId() != null) {
			// carrega paciente ID
			Paciente paciente = pacienteService.fetchById(data.getPacienteId());
			consulta.setPaciente(paciente);	
		}
		
		consultaService.createConsultaWithValidations(consulta);
		data.setId(consulta.getId());
		data.setStatus(consulta.getStatus());
		
		return new ResponseEntity<Object>(data, HttpStatus.CREATED);
	}
	
}
